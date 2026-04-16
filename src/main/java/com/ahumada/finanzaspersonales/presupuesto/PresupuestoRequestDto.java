package com.ahumada.finanzaspersonales.presupuesto;

import java.time.YearMonth;

public class PresupuestoRequestDto {

    private YearMonth periodo;
    private EstadoPresupuesto estado;

    public YearMonth getPeriodo() {
        return periodo;
    }

    public void setPeriodo(YearMonth periodo) {
        this.periodo = periodo;
    }

    public EstadoPresupuesto getEstado() {
        return estado;
    }

    public void setEstado(EstadoPresupuesto estado) {
        this.estado = estado;
    }
}
