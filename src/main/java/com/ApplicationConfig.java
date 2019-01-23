package com;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.mail.javamail.JavaMailSender;
import org.springframework.mail.javamail.JavaMailSenderImpl;
import org.springframework.ui.freemarker.FreeMarkerConfigurationFactoryBean;

import java.util.Properties;

/**
 * @author <a href='http://programmerinaction'>Nelson Castro</a>
 * @since 1.0
 */

@Configuration
@ComponentScan(basePackages = "com")
public class ApplicationConfig {

    @Bean
    public JavaMailSender getMailSender() {
        JavaMailSenderImpl mailSender = new JavaMailSenderImpl();

        mailSender.setHost("127.0.0.1");
        mailSender.setPort(587);
        mailSender.setUsername("nelsoncastro.developer@gmail.com");
        mailSender.setPassword("12345");

        Properties javaMailProperties = new Properties();
        javaMailProperties.put("mail.smtp.starttls.enable", "true");
        javaMailProperties.put("mail.smtp.auth", "true");
        javaMailProperties.put("mail.transport.protocol", "smtp");
        javaMailProperties.put("mail.debug", "true");

        mailSender.setJavaMailProperties(javaMailProperties);

        return mailSender;
    }

    @Bean
    public FreeMarkerConfigurationFactoryBean getFreeMarkerConfiguration() {
        FreeMarkerConfigurationFactoryBean cfg = new FreeMarkerConfigurationFactoryBean();
        cfg.setTemplateLoaderPath("/templates/");
        cfg.setDefaultEncoding("ISO-8859-1");
        return cfg;
    }
}
