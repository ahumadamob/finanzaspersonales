package com.ahumada.finanzaspersonales.presupuesto;

import java.time.YearMonth;

import com.ahumada.finanzaspersonales.common.BaseEntity;

import jakarta.persistence.Column;
import jakarta.persistence.Convert;
import jakarta.persistence.Entity;
import jakarta.persistence.EnumType;
import jakarta.persistence.Enumerated;
import jakarta.persistence.Table;
import jakarta.persistence.Version;
import jakarta.validation.constraints.NotNull;

@Entity
@Table(name = "presupuestos")
public class Presupuesto extends BaseEntity {

    @Column(name = "periodo", nullable = false, length = 7)
    @Convert(converter = YearMonthStringConverter.class)
    @NotNull
    private YearMonth periodo;

    @Version
    @Column(name = "version", nullable = false)
    private int version;

    @Enumerated(EnumType.STRING)
    @Column(name = "estado", nullable = false, length = 32)
    @NotNull
    private EstadoPresupuesto estado;

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
}
