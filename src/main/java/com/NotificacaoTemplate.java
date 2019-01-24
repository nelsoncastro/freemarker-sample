package com;

import lombok.Getter;

import java.io.Serializable;
import java.math.BigDecimal;

@Getter
public class NotificacaoTemplate implements Serializable {

    private String mensagem;
    private String solicitante;
    private String numeroChargeback;
    private BigDecimal valorDisputa;
    private String entidadeSolicitante;
    private String entidadeRequerida;

    public NotificacaoTemplate(String mensagem, String solicitante, String numeroChargeback, BigDecimal valorDisputa, String entidadeSolicitante, String entidadeRequerida) {
        this.mensagem = mensagem;
        this.solicitante = solicitante;
        this.numeroChargeback = numeroChargeback;
        this.valorDisputa = valorDisputa;
        this.entidadeSolicitante = entidadeSolicitante;
        this.entidadeRequerida = entidadeRequerida;
    }
}
