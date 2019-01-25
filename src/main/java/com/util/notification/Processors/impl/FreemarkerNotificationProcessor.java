package com.util.notification.Processors.impl;

import com.util.notification.Processors.NotificationProcessor;
import freemarker.template.Configuration;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import org.springframework.ui.freemarker.FreeMarkerTemplateUtils;

import java.util.Map;

@Component("freemarkerNotificationProcessor")
public class FreemarkerNotificationProcessor implements NotificationProcessor {

    private Logger logger = LoggerFactory.getLogger(getClass());

    @Autowired
    private Configuration configuration;

    @Override
    public String process(String templateFile, Map<String, Object> model) {
        try {
            return FreeMarkerTemplateUtils.processTemplateIntoString(configuration.getTemplate(templateFile), model);
        } catch (Exception e) {
            logger.error(e.getMessage());
            throw new IllegalStateException("FreemarkerNotificationProcessor failure: " + e.getMessage());
        }
    }
}
