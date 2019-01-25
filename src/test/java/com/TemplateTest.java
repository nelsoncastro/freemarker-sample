package com;

import com.config.ApplicationConfig;
import com.model.service.MailService;
import com.util.mail.Mail;
import com.util.notification.Processors.NotificationProcessor;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import java.math.BigDecimal;
import java.util.HashMap;
import java.util.Map;

@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration(classes = ApplicationConfig.class)
public class TemplateTest {

    @Autowired
    private MailService mailService;

    @Autowired
    private NotificationProcessor processor;


    @Test
    public void templateSolicitacao() {
        NotificationTemplate notificacao = new NotificationTemplate.Builder(
                "O seu pedido de ChargebackNotification foi registrado. O acompanhamento pode ser realizado pela plataforma Cabal NET."
                , "Fulano De Tal"
                , "0000000001"
                , new BigDecimal(100.00)
                , "BANCO DO BRASIL"
                , "ELO").build();

        Map<String, Object> model = new HashMap<>();
        model.put("dado", notificacao);

        Mail mail = new Mail.Builder("atendimento@gmail.com", "fulanodetal@gmail.com", "EMPRESA - SOLICITAÇÃO DE CHARGEBACK",
                processor.process("chargeback/content.ftl", model)).build();

        mailService.sendMail(mail);
    }

}
