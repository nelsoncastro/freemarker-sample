package com.util.notification;

import lombok.Getter;

import java.io.Serializable;
import java.math.BigDecimal;

@Getter
public class NotificationTemplate implements Serializable {

    private String solicitante;
    private String mensagem;
    private String numeroChargeback;
    private BigDecimal valorDisputa;
    private String entidadeSolicitante;
    private String entidadeRequerida;

    public NotificationTemplate(Builder builder) {
        this.mensagem = builder.mensagem;
        this.solicitante = builder.solicitante;
        this.numeroChargeback = builder.numeroChargeback;
        this.valorDisputa = builder.valorDisputa;
        this.entidadeSolicitante = builder.entidadeSolicitante;
        this.entidadeRequerida = builder.entidadeRequerida;
    }

    public static class Builder {
        String mensagem;
        String solicitante;
        String numeroChargeback;
        BigDecimal valorDisputa;
        String entidadeSolicitante;
        String entidadeRequerida;

        public Builder(String mensagem, String solicitante, String numeroChargeback, BigDecimal valorDisputa, String entidadeSolicitante, String entidadeRequerida) {
            this.mensagem = mensagem;
            this.solicitante = solicitante;
            this.numeroChargeback = numeroChargeback;
            this.valorDisputa = valorDisputa;
            this.entidadeSolicitante = entidadeSolicitante;
            this.entidadeRequerida = entidadeRequerida;
        }

        public NotificationTemplate build() {
            return new NotificationTemplate(this);
        }
    }
}
