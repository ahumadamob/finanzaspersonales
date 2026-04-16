package com.ahumada.finanzaspersonales.plazofijo;

import java.math.BigDecimal;
import java.time.LocalDate;
import java.time.LocalDateTime;

public class PlazoFijoResponseDto {

    private Long id;
    private Long cuentaId;
    private Long capitalInicialId;
    private BigDecimal tasaNominalAnual;
    private Integer plazoDias;
    private LocalDate fechaConstitucion;
    private LocalDate fechaVencimiento;
    private Long itemPresupuestoId;
    private LocalDateTime fechaCreacion;
    private LocalDateTime fechaModificacion;

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public Long getCuentaId() {
        return cuentaId;
    }

    public void setCuentaId(Long cuentaId) {
        this.cuentaId = cuentaId;
    }

    public Long getCapitalInicialId() {
        return capitalInicialId;
    }

    public void setCapitalInicialId(Long capitalInicialId) {
        this.capitalInicialId = capitalInicialId;
    }

    public BigDecimal getTasaNominalAnual() {
        return tasaNominalAnual;
    }

    public void setTasaNominalAnual(BigDecimal tasaNominalAnual) {
        this.tasaNominalAnual = tasaNominalAnual;
    }

    public Integer getPlazoDias() {
        return plazoDias;
    }

    public void setPlazoDias(Integer plazoDias) {
        this.plazoDias = plazoDias;
    }

    public LocalDate getFechaConstitucion() {
        return fechaConstitucion;
    }

    public void setFechaConstitucion(LocalDate fechaConstitucion) {
        this.fechaConstitucion = fechaConstitucion;
    }

    public LocalDate getFechaVencimiento() {
        return fechaVencimiento;
    }

    public void setFechaVencimiento(LocalDate fechaVencimiento) {
        this.fechaVencimiento = fechaVencimiento;
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
