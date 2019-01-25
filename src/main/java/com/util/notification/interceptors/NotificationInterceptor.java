package com.util.notification.interceptors;


import com.model.entity.Chargeback;
import com.model.enums.NotificationType;
import com.model.service.MailService;
import com.util.mail.Mail;
import com.util.notification.Notification;
import com.util.notification.NotificationTemplate;
import com.util.notification.Processors.NotificationProcessor;
import org.aspectj.lang.JoinPoint;
import org.aspectj.lang.annotation.After;
import org.aspectj.lang.annotation.Aspect;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.util.HashMap;
import java.util.Map;

@Component
@Aspect
public class NotificationInterceptor {

    @Autowired
    private MailService mailService;

    @Autowired
    private NotificationProcessor processor;


    @After(value = "@annotation(notification) && args(param )")
    public void sendMail(JoinPoint jp, Notification notification, Object param) {
        System.out.println("sending " + notification.type() + " notification after called from " + jp.getSignature().getName() + " method...");

        if (notification.type() == NotificationType.CHARGEBACK) {

            Chargeback chargeback = (Chargeback) param;
            NotificationTemplate notificacao = new NotificationTemplate.Builder(
                    "O seu pedido de Chargeback foi registrado. O acompanhamento pode ser realizado pela plataforma Cabal NET."
                    , chargeback.getSolicitante()
                    , chargeback.getNumeroChargeback()
                    , chargeback.getValorDisputa()
                    , chargeback.getEntidadeSolicitante()
                    , chargeback.getEntidadeRequerida()).build();

            Map<String, Object> model = new HashMap<>();
            model.put("dado", notificacao);

            // obter todos os remetentes do emissor e adquirente para envio de notificação

            String[] mailTo = {"sobrinhos@tiopatinhas.com"};

            Mail mail = new Mail.Builder("atendimento@bandeira.com", mailTo[0], "BANDEIRA - SOLICITAÇÃO DE CHARGEBACK",
                    processor.process("chargeback/content.ftl", model)).build();

            mailService.sendMail(mail);
        }

    }
}
