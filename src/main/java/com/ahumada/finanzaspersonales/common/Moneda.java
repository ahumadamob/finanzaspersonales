package com.ahumada.finanzaspersonales.common;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.Table;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Size;

@Entity
@Table(name = "monedas")
public class Moneda extends BaseEntity {
	
	@Column(name = "nombre", nullable = false, length = 64)
    @NotNull
    @NotBlank
    @Size(max = 64)
	private String nombre;	

	public String getNombre() {
		return nombre;
	}

	public void setNombre(String nombre) {
		this.nombre = nombre;
	}
	
	
}
