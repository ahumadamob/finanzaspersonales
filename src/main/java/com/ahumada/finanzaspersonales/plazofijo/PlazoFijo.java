package com.ahumada.finanzaspersonales.plazofijo;

import java.math.BigDecimal;
import java.time.LocalDate;

import com.ahumada.finanzaspersonales.common.BaseEntity;
import com.ahumada.finanzaspersonales.common.ImporteMonetario;
import com.ahumada.finanzaspersonales.cuenta.Cuenta;
import com.ahumada.finanzaspersonales.itempresupuesto.ItemPresupuesto;
import com.ahumada.finanzaspersonales.plazofijo.validation.FechasPlazoFijoValidas;

import jakarta.persistence.Entity;
import jakarta.persistence.FetchType;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.Table;
import jakarta.persistence.Column;
import jakarta.validation.constraints.DecimalMax;
import jakarta.validation.constraints.DecimalMin;
import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Positive;

@Entity
@Table(name = "plazos_fijos")
@FechasPlazoFijoValidas
public class PlazoFijo extends BaseEntity {

	@ManyToOne(fetch = FetchType.LAZY, optional = false)
	@JoinColumn(name = "cuenta_id", nullable = false)
	@NotNull
	private Cuenta cuenta;
	

	@ManyToOne(fetch = FetchType.LAZY, optional = false)
	@JoinColumn(name = "capital_inicial_id", nullable = false)
	@NotNull	
	private ImporteMonetario capitalInicial;
	
	@NotNull
	@DecimalMin("0.0000")
	@DecimalMax("100.0000")
	@Column(nullable = false, precision = 7, scale = 4)
	private BigDecimal tasaNominalAnual;
	
	@NotNull
	@Positive
	@Column(nullable = false, name = "plazo_dias")
	private Integer plazoDias;

	@NotNull
	@Column(nullable = false, name = "fecha_constitucion")
	private LocalDate fechaConstitucion;

	@NotNull
	@Column(nullable = false, name = "fecha_vencimiento")
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
