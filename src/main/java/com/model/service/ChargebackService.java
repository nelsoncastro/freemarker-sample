package com.model.service;

import com.model.entity.Chargeback;

import java.io.Serializable;

public interface ChargebackService extends Serializable {

    void generateChargeback(Chargeback chargeback);
}
