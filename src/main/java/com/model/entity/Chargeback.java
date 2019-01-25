package com.model.entity;

import lombok.AllArgsConstructor;
import lombok.Getter;
import org.apache.commons.lang3.builder.ToStringBuilder;
import org.apache.commons.lang3.builder.ToStringStyle;

import java.io.Serializable;
import java.math.BigDecimal;

@Getter
@AllArgsConstructor
public class Chargeback implements Serializable {

    private Long id;
    private String solicitante;
    private String numeroChargeback;
    private BigDecimal valorDisputa;
    private String entidadeSolicitante;
    private String entidadeRequerida;

    @Override
    public String toString() {
        return ToStringBuilder.reflectionToString(this, ToStringStyle.MULTI_LINE_STYLE);
    }
}
