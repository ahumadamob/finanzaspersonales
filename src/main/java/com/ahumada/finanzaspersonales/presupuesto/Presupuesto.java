package com.ahumada.finanzaspersonales.presupuesto;

import java.time.YearMonth;

import com.ahumada.finanzaspersonales.common.BaseEntity;

public class Presupuesto extends BaseEntity {

    private YearMonth periodo;
    private int version;
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
