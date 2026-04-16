package com.ahumada.finanzaspersonales.transaccion;

import java.time.LocalDateTime;

public class TransaccionRequestDto {

    private Long importeId;
    private LocalDateTime fechaTransaccion;
    private Long cuentaId;
    private Long itemPresupuestoId;

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
}
