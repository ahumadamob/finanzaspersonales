package com.ahumada.finanzaspersonales.categoriaitempresupuesto;

import com.ahumada.finanzaspersonales.common.BaseEntity;
import com.ahumada.finanzaspersonales.usuario.Usuario;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.EnumType;
import jakarta.persistence.Enumerated;
import jakarta.persistence.FetchType;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.Table;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Size;

@Entity
@Table(name = "categorias_item_presupuesto")
public class CategoriaItemPresupuesto extends BaseEntity {
	
	@Column(name = "nombre", nullable = false, length = 64)
    @NotNull
    @NotBlank
    @Size(max = 64)
	private String nombre;
	
	@Enumerated(EnumType.STRING)
	@Column(name = "tipo", nullable = false, length = 16)
	@NotNull
	private TipoItemPresupuesto tipo;
	
	@ManyToOne(fetch = FetchType.LAZY, optional = false)
	@JoinColumn(name = "usuario_id", nullable = false)
	@NotNull
	private Usuario usuario;
	
	private boolean retirado;

	public String getNombre() {
		return nombre;
	}

	public void setNombre(String nombre) {
		this.nombre = nombre;
	}

	public TipoItemPresupuesto getTipo() {
		return tipo;
	}

	public void setTipo(TipoItemPresupuesto tipo) {
		this.tipo = tipo;
	}

	public Usuario getUsuario() {
		return usuario;
	}

	public void setUsuario(Usuario usuario) {
		this.usuario = usuario;
	}

	public boolean isRetirado() {
		return retirado;
	}

	public void setRetirado(boolean retirado) {
		this.retirado = retirado;
	}	

}
