package com.ahumada.finanzaspersonales.itempresupuesto;

import java.time.LocalDateTime;

public class ItemPresupuestoResponseDto {

    private Long id;
    private Long categoriaId;
    private Long importeMonetarioId;
    private LocalDateTime fechaVencimiento;
    private boolean consolidado;
    private Long itemReferenciaId;
    private LocalDateTime fechaCreacion;
    private LocalDateTime fechaModificacion;

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

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
