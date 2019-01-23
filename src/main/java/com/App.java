package com;

import org.springframework.context.annotation.AnnotationConfigApplicationContext;
import org.springframework.context.support.AbstractApplicationContext;

import java.util.HashMap;
import java.util.Map;

/**
 * @author <a href='http://programmerinaction'>Nelson Castro</a>
 * @since 1.0
 */
public class App {

    public static void main(String[] args) {
        Mail mail = new Mail();
        mail.setMailFrom("nelsoncastro.developer@gmail.com");
        mail.setMailTo("nelsoncastro.developer@gmail.com");
        mail.setMailSubject("CABAL - SOLICITAÇÃO DE CHARGEBACK");

        Map<String, Object> model = new HashMap<>();
        mail.setModel(model);

        AbstractApplicationContext ctx = new AnnotationConfigApplicationContext(ApplicationConfig.class);
        MailService mailService = (MailService) ctx.getBean("mailService");
        mailService.sendMail(mail);
        ctx.close();
    }
}
