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
    private String usuarioAbertura;

    public Chargeback(Builder builder) {
        this.solicitante = builder.solicitante;
        this.numeroChargeback = builder.numeroChargeback;
        this.valorDisputa = builder.valorDisputa;
        this.entidadeSolicitante = builder.entidadeSolicitante;
        this.entidadeRequerida = builder.entidadeRequerida;
        this.usuarioAbertura = builder.usuarioAbertura;
    }

    @Override
    public String toString() {
        return ToStringBuilder.reflectionToString(this, ToStringStyle.MULTI_LINE_STYLE);
    }

    public void setId(Long id) {
        this.id = id;
    }

    public static class Builder {

        private String solicitante;
        private String numeroChargeback;
        private BigDecimal valorDisputa;
        private String entidadeSolicitante;
        private String entidadeRequerida;
        private String usuarioAbertura;

        public Builder(String solicitante, String numeroChargeback, BigDecimal valorDisputa, String entidadeSolicitante, String entidadeRequerida,
                       String usuarioAbertura) {
            this.solicitante = solicitante;
            this.numeroChargeback = numeroChargeback;
            this.valorDisputa = valorDisputa;
            this.entidadeSolicitante = entidadeSolicitante;
            this.entidadeRequerida = entidadeRequerida;
            this.usuarioAbertura = usuarioAbertura;
        }

        public Chargeback build() {
            return new Chargeback(this);
        }
    }
}
