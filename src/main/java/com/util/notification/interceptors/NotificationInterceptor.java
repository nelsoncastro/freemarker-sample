package com.util.notification.interceptors;


import com.model.service.MailService;
import com.util.notification.Notification;
import org.aspectj.lang.JoinPoint;
import org.aspectj.lang.annotation.After;
import org.aspectj.lang.annotation.Aspect;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

@Component
@Aspect
public class NotificationInterceptor {

    @Autowired
    private MailService mailService;

    @After(value = "@annotation(notification) && args(param )")
    public void sendMail(JoinPoint jp, Notification notification, Object param) {
        System.out.println("sending " + notification.type() + " notification after called from " + jp.getSignature().getName() + " method...");
    }
}
