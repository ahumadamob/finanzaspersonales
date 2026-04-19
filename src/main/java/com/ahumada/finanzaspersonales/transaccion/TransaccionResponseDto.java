package com.ahumada.finanzaspersonales.transaccion;

import java.time.LocalDateTime;

public class TransaccionResponseDto {

    private Long id;
    private Long importeId;
    private LocalDateTime fechaTransaccion;
    private Long cuentaId;
    private Long itemPresupuestoId;
    private LocalDateTime fechaCreacion;
    private LocalDateTime fechaModificacion;

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public Long getImporteId() {
        return importeId;
    }

    public void setImporteId(Long importeId) {
        this.importeId = importeId;
    }

    public LocalDateTime getFechaTransaccion() {
        return fechaTransaccion;
    }

    public void setFechaTransaccion(LocalDateTime fechaTransaccion) {
        this.fechaTransaccion = fechaTransaccion;
    }

    public Long getCuentaId() {
        return cuentaId;
    }

    public void setCuentaId(Long cuentaId) {
        this.cuentaId = cuentaId;
    }

    public Long getItemPresupuestoId() {
        return itemPresupuestoId;
    }

    public void setItemPresupuestoId(Long itemPresupuestoId) {
        this.itemPresupuestoId = itemPresupuestoId;
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
