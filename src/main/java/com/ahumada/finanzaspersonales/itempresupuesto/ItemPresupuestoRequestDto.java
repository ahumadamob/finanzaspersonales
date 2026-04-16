package com.ahumada.finanzaspersonales.itempresupuesto;

import java.time.LocalDateTime;

public class ItemPresupuestoRequestDto {

    private Long categoriaId;
    private Long importeMonetarioId;
    private LocalDateTime fechaVencimiento;
    private boolean consolidado;
    private Long itemReferenciaId;

    public Long getCategoriaId() {
        return categoriaId;
    }

    public void setCategoriaId(Long categoriaId) {
        this.categoriaId = categoriaId;
    }

    public Long getImporteMonetarioId() {
        return importeMonetarioId;
    }

    public void setImporteMonetarioId(Long importeMonetarioId) {
        this.importeMonetarioId = importeMonetarioId;
    }

    public LocalDateTime getFechaVencimiento() {
        return fechaVencimiento;
    }

    public void setFechaVencimiento(LocalDateTime fechaVencimiento) {
        this.fechaVencimiento = fechaVencimiento;
    }

    public boolean isConsolidado() {
        return consolidado;
    }

    public void setConsolidado(boolean consolidado) {
        this.consolidado = consolidado;
    }

    public Long getItemReferenciaId() {
        return itemReferenciaId;
    }

    public void setItemReferenciaId(Long itemReferenciaId) {
        this.itemReferenciaId = itemReferenciaId;
    }
}
