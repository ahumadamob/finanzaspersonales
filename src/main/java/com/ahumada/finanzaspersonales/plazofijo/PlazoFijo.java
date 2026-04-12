package com.ahumada.finanzaspersonales.plazofijo;

import java.math.BigDecimal;
import java.time.LocalDate;

import com.ahumada.finanzaspersonales.common.BaseEntity;
import com.ahumada.finanzaspersonales.common.ImporteMonetario;
import com.ahumada.finanzaspersonales.cuenta.Cuenta;
import com.ahumada.finanzaspersonales.itempresupuesto.ItemPresupuesto;

import jakarta.persistence.Entity;
import jakarta.persistence.FetchType;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.Table;
import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Positive;

@Entity
@Table(name = "plazos_fijo")
public class PlazoFijo extends BaseEntity {

	@ManyToOne(fetch = FetchType.LAZY, optional = false)
	@JoinColumn(name = "cuenta_id", nullable = false)
	@NotNull
	private Cuenta cuenta;
	

	@ManyToOne(fetch = FetchType.LAZY, optional = false)
	@JoinColumn(name = "capital_inicial", nullable = false)
	@NotNull	
	private ImporteMonetario capitalInicial;
	private BigDecimal tasaNominalAnual;
	
	@Positive
	private Integer plazoDias;
	private LocalDate fechaConstitucion;
	private LocalDate fechaVencimiento;
	
	@ManyToOne(fetch = FetchType.LAZY, optional = false)
	@JoinColumn(name = "item_presupuesto_id", nullable = false)
	@NotNull
	private ItemPresupuesto itemPresupuesto;

	public Cuenta getCuenta() {
		return cuenta;
	}

	public void setCuenta(Cuenta cuenta) {
		this.cuenta = cuenta;
	}

	public ImporteMonetario getCapitalInicial() {
		return capitalInicial;
	}

	public void setCapitalInicial(ImporteMonetario capitalInicial) {
		this.capitalInicial = capitalInicial;
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

	public ItemPresupuesto getItemPresupuesto() {
		return itemPresupuesto;
	}

	public void setItemPresupuesto(ItemPresupuesto itemPresupuesto) {
		this.itemPresupuesto = itemPresupuesto;
	}
	
	

}
