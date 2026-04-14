package com.ahumada.finanzaspersonales.usuario;

import com.ahumada.finanzaspersonales.common.BaseEntity;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.Table;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Size;

@Entity
@Table(name = "usuarios")
public class Usuario extends BaseEntity{
	
	@Column(name = "nombre", nullable = false, length = 64)
    @NotNull
    @NotBlank
    @Size(max = 64)
	private String nombre;
	
	@Column(nullable = false, columnDefinition = "boolean default false")
	private boolean retirado = false;
	
	public Usuario() {}
	
	public Usuario(Long id) {
		super.id = id;
	}

	public String getNombre() {
		return nombre;
	}

	public void setNombre(String nombre) {
		this.nombre = nombre;
	}

	public boolean isRetirado() {
		return retirado;
	}

	public void setRetirado(boolean retirado) {
		this.retirado = retirado;
	}
	
	

}
