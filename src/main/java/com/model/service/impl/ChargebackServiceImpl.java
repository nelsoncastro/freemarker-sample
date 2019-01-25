package com.model.service.impl;

import com.model.entity.Chargeback;
import com.model.enums.NotificationType;
import com.model.service.ChargebackService;
import com.util.notification.Notification;
import org.springframework.stereotype.Service;

@Service("chargebackService")
public class ChargebackServiceImpl implements ChargebackService {

    @Notification(type = NotificationType.CHARGEBACK)
    @Override
    public void generateChargeback(Chargeback chargeback) {
        System.out.println("gerando chargeback...");
    }
}
