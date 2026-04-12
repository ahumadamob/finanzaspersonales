package com.ahumada.finanzaspersonales.cuenta;

import java.time.LocalDateTime;

import com.ahumada.finanzaspersonales.usuario.UsuarioResponseDto;

public class CuentaResponseDto {
	
	private Long id;
	private String nombre;
	private UsuarioResponseDto usuario;
	private LocalDateTime fechaCreacion;
	private LocalDateTime fechaModificacion;
	public Long getId() {
		return id;
	}
	public void setId(Long id) {
		this.id = id;
	}
	public String getNombre() {
		return nombre;
	}
	public void setNombre(String nombre) {
		this.nombre = nombre;
	}
	public UsuarioResponseDto getUsuario() {
		return usuario;
	}
	public void setUsuario(UsuarioResponseDto usuario) {
		this.usuario = usuario;
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
