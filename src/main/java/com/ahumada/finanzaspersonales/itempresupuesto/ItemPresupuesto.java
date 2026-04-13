package com.ahumada.finanzaspersonales.itempresupuesto;

import java.time.LocalDateTime;

import com.ahumada.finanzaspersonales.categoriaitempresupuesto.CategoriaItemPresupuesto;
import com.ahumada.finanzaspersonales.common.BaseEntity;
import com.ahumada.finanzaspersonales.common.ImporteMonetario;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.FetchType;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.Table;
import jakarta.validation.constraints.NotNull;

@Entity
@Table(name = "items_presupuesto")
public class ItemPresupuesto extends BaseEntity {
	
	@ManyToOne(fetch = FetchType.LAZY, optional = false)
	@JoinColumn(name = "categoria_id", nullable = false)
	@NotNull
	private CategoriaItemPresupuesto categoria;
	
	@ManyToOne(fetch = FetchType.LAZY, optional = false)
	@JoinColumn(name = "importe_monetario_id", nullable = false)
	@NotNull	
	private ImporteMonetario importeMonetario;
	
	@Column(name = "fecha_vencimiento")
	private LocalDateTime fechaVencimiento;
	
	@Column(nullable = false, columnDefinition = "boolean default false")
	private boolean consolidado = false;	
	
	@Column(name = "item_referencia_id")
	private Long itemReferenciaId;

	public CategoriaItemPresupuesto getCategoria() {
		return categoria;
	}

	public void setCategoria(CategoriaItemPresupuesto categoria) {
		this.categoria = categoria;
	}

	public ImporteMonetario getImporteMonetario() {
		return importeMonetario;
	}

	public void setImporteMonetario(ImporteMonetario importeMonetario) {
		this.importeMonetario = importeMonetario;
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
