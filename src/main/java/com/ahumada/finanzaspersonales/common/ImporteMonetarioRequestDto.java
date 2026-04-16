package com.ahumada.finanzaspersonales.common;

import java.math.BigDecimal;

public class ImporteMonetarioRequestDto {

    private Long monedaId;
    private BigDecimal monto;

    public Long getMonedaId() {
        return monedaId;
    }

    public void setMonedaId(Long monedaId) {
        this.monedaId = monedaId;
    }

    public BigDecimal getMonto() {
        return monto;
    }

    public void setMonto(BigDecimal monto) {
        this.monto = monto;
    }
}
