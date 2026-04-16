package com.ahumada.finanzaspersonales.categoriaitempresupuesto;

public class CategoriaItemPresupuestoRequestDto {

    private String nombre;
    private TipoItemPresupuesto tipo;
    private Long usuarioId;

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

    public Long getUsuarioId() {
        return usuarioId;
    }

    public void setUsuarioId(Long usuarioId) {
        this.usuarioId = usuarioId;
    }
}
