package com.util.notification;

import com.model.enums.NotificationType;

import java.lang.annotation.*;

@Retention(RetentionPolicy.RUNTIME)
@Target({ElementType.TYPE, ElementType.METHOD})
@Documented
public @interface Notification {

    NotificationType type();
}
