package com.ahumada.finanzaspersonales.categoriaitempresupuesto;

import com.ahumada.finanzaspersonales.usuario.Usuario;

public class CategoriaItemPresupuestoMapper {

    public CategoriaItemPresupuesto toEntity(CategoriaItemPresupuestoRequestDto dto, Usuario usuario) {
        CategoriaItemPresupuesto entity = new CategoriaItemPresupuesto();
        entity.setNombre(dto.getNombre());
        entity.setTipo(dto.getTipo());
        entity.setUsuario(usuario);
        return entity;
    }

    public CategoriaItemPresupuestoResponseDto toResponseDto(CategoriaItemPresupuesto entity) {
        CategoriaItemPresupuestoResponseDto dto = new CategoriaItemPresupuestoResponseDto();
        dto.setId(entity.getId());
        dto.setNombre(entity.getNombre());
        dto.setTipo(entity.getTipo());
        dto.setUsuarioId(entity.getUsuario().getId());
        dto.setFechaCreacion(entity.getFechaCreacion());
        dto.setFechaModificacion(entity.getFechaModificacion());
        return dto;
    }
}
