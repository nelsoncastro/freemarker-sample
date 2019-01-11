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
        mail.setMailFrom("your-email@gmail.com");
        mail.setMailTo("your-email@gmail.com");
        mail.setMailSubject("Spring - Email with FreeMarker template");

        Map<String, Object> model = new HashMap<>();
        model.put("firstName", "Cabal");
        model.put("lastName", "Brasil");
        model.put("location", "Brasília-DF");
        model.put("signature", "www.cabalbrasil.com.br");
        mail.setModel(model);

        AbstractApplicationContext ctx = new AnnotationConfigApplicationContext(ApplicationConfig.class);
        MailService mailService = (MailService) ctx.getBean("mailService");
        mailService.sendMail(mail);
        ctx.close();
    }
}
