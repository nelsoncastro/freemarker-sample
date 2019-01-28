package com.model.service;

import com.model.entity.Chargeback;

import java.io.Serializable;

public interface ChargebackService extends Serializable {

    Chargeback create(Chargeback chargeback);
}
