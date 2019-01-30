package com.config;

import org.springframework.mail.javamail.JavaMailSender;
import org.springframework.mail.javamail.JavaMailSenderImpl;
import org.springframework.ui.freemarker.FreeMarkerConfigurationFactoryBean;

import java.util.Properties;

//@Configuration
//@ComponentScan(basePackages = "com")
//@EnableAspectJAutoProxy
public class ApplicationConfig {

    //  @Bean
    public JavaMailSender getMailSender() {
        JavaMailSenderImpl mailSender = new JavaMailSenderImpl();

        mailSender.setHost("127.0.0.1");
        mailSender.setPort(587);
        mailSender.setUsername("username");
        mailSender.setPassword("password");

        Properties javaMailProperties = new Properties();
        javaMailProperties.put("mail.smtp.starttls.enable", "true");
        javaMailProperties.put("mail.smtp.auth", "true");
        javaMailProperties.put("mail.transport.protocol", "smtp");
        javaMailProperties.put("mail.debug", "true");

        mailSender.setJavaMailProperties(javaMailProperties);

        return mailSender;
    }

    //    @Bean
    public FreeMarkerConfigurationFactoryBean getFreeMarkerConfiguration() {
        FreeMarkerConfigurationFactoryBean cfg = new FreeMarkerConfigurationFactoryBean();
        cfg.setTemplateLoaderPath("/templates/");
        cfg.setDefaultEncoding("ISO-8859-1");
        return cfg;
    }
}
