package com.ahumada.finanzaspersonales.transaccion;

import java.time.LocalDateTime;

import com.ahumada.finanzaspersonales.common.BaseEntity;
import com.ahumada.finanzaspersonales.common.ImporteMonetario;
import com.ahumada.finanzaspersonales.cuenta.Cuenta;
import com.ahumada.finanzaspersonales.itempresupuesto.ItemPresupuesto;

import jakarta.persistence.Entity;
import jakarta.persistence.FetchType;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.Table;
import jakarta.persistence.Column;
import jakarta.validation.constraints.NotNull;

@Entity
@Table(name = "transacciones")
public class Transaccion extends BaseEntity {
	
	@ManyToOne(fetch = FetchType.LAZY, optional = false)
	@JoinColumn(name = "importe_monetario_id", nullable = false)
	@NotNull
	private ImporteMonetario importe;
	
	@NotNull
	@Column(nullable = false, name = "fecha_transaccion")
	private LocalDateTime fechaTransaccion;
	
	@ManyToOne(fetch = FetchType.LAZY, optional = false)
	@JoinColumn(name = "cuenta_id", nullable = false)
	@NotNull
	private Cuenta cuenta;
	
	@ManyToOne(fetch = FetchType.LAZY, optional = false)
	@JoinColumn(name = "item_presupuesto_id", nullable = false)
	@NotNull
	private ItemPresupuesto itemPresupuesto;

	public ImporteMonetario getImporte() {
		return importe;
	}

	public void setImporte(ImporteMonetario importe) {
		this.importe = importe;
	}

	public LocalDateTime getFechaTransaccion() {
		return fechaTransaccion;
	}

	public void setFechaTransaccion(LocalDateTime fechaTransaccion) {
		this.fechaTransaccion = fechaTransaccion;
	}

	public Cuenta getCuenta() {
		return cuenta;
	}

	public void setCuenta(Cuenta cuenta) {
		this.cuenta = cuenta;
	}

	public ItemPresupuesto getItemPresupuesto() {
		return itemPresupuesto;
	}

	public void setItemPresupuesto(ItemPresupuesto itemPresupuesto) {
		this.itemPresupuesto = itemPresupuesto;
	}
	

}
