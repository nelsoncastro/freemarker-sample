package com.model.service.impl;

import com.model.entity.Chargeback;
import com.model.enums.NotificationType;
import com.model.service.ChargebackService;
import com.util.notification.Notification;
import org.apache.commons.lang3.StringUtils;
import org.springframework.stereotype.Service;

@Service("chargebackService")
public class ChargebackServiceImpl implements ChargebackService {

    @Notification(type = NotificationType.CHARGEBACK)
    @Override
    public Chargeback create(Chargeback chargeback) {
        System.out.println("gerando chargeback...");

        assert StringUtils.isNotBlank(chargeback.getSolicitante());

        chargeback.setId(1L);
        return chargeback;
    }
}
