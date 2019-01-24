package com;

import com.config.ApplicationConfig;
import freemarker.template.Configuration;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;
import org.springframework.ui.freemarker.FreeMarkerTemplateUtils;

import java.math.BigDecimal;
import java.util.HashMap;
import java.util.Map;

@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration(classes = ApplicationConfig.class)
public class TemplateTest {

    @Autowired
    private MailService mailService;

    @Autowired
    private Configuration configuration;

    private Mail mail;

    @Before
    public void init() {
        mail = new Mail();
        mail.setMailFrom("atendimento@gmail.com");
        mail.setMailTo("fulanodetal@gmail.com");
    }

    @Test
    public void templateSolicitacao() {
        mail.setMailSubject("EMPRESA - SOLICITAÇÃO DE CHARGEBACK");

        NotificacaoTemplate notificacao = new NotificacaoTemplate(
                "O seu pedido de Chargeback foi registrado. O acompanhamento pode ser realizado pela plataforma Cabal NET."
                , "Fulano De Tal"
                , "0000000001"
                , new BigDecimal(100.00)
                , "BANCO DO BRASIL"
                , "ELO");

        Map<String, Object> model = new HashMap<>();
        model.put("dado", notificacao);

        mail.setMailContent(getContentFromTemplate("mail.ftl", model));

        mailService.sendMail(mail);
    }

    private String getContentFromTemplate(String templateFile, Map<String, Object> model) {
        StringBuffer content = new StringBuffer();
        try {
            content.append(FreeMarkerTemplateUtils.processTemplateIntoString(configuration.getTemplate(templateFile), model));
        } catch (Exception ex) {
            ex.printStackTrace();
        }
        return content.toString();
    }
}
