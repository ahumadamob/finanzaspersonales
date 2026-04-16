package com.ahumada.finanzaspersonales.categoriaitempresupuesto;

import java.time.LocalDateTime;

public class CategoriaItemPresupuestoResponseDto {

    private Long id;
    private String nombre;
    private TipoItemPresupuesto tipo;
    private Long usuarioId;
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
