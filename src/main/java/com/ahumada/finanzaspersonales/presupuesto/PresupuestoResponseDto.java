package com.ahumada.finanzaspersonales.presupuesto;

import java.time.LocalDateTime;
import java.time.YearMonth;

public class PresupuestoResponseDto {

    private Long id;
    private YearMonth periodo;
    private int version;
    private EstadoPresupuesto estado;
    private LocalDateTime fechaCreacion;
    private LocalDateTime fechaModificacion;

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public YearMonth getPeriodo() {
        return periodo;
    }

    public void setPeriodo(YearMonth periodo) {
        this.periodo = periodo;
    }

    public int getVersion() {
        return version;
    }

    public void setVersion(int version) {
        this.version = version;
    }

    public EstadoPresupuesto getEstado() {
        return estado;
    }

    public void setEstado(EstadoPresupuesto estado) {
        this.estado = estado;
    }

    public LocalDateTime getFechaCreacion() {
        return fechaCreacion;
    }

    public void setFechaCreacion(LocalDateTime fechaCreacion) {
        this.fechaCreacion = fechaCreacion;
    }

    public LocalDateTime getFechaModificacion() {
        return fechaModificacion;
    }

    public void setFechaModificacion(LocalDateTime fechaModificacion) {
        this.fechaModificacion = fechaModificacion;
    }
}
