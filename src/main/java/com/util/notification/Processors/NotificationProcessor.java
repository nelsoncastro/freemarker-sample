package com.util.notification.Processors;

import java.io.Serializable;
import java.util.Map;

public interface NotificationProcessor extends Serializable {

    String process(String templateFile, Map<String, Object> model);
}
