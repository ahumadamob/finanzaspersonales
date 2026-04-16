package com.ahumada.finanzaspersonales.common;

public class MonedaMapper {

    public Moneda toEntity(MonedaRequestDto dto) {
        Moneda entity = new Moneda();
        entity.setNombre(dto.getNombre());
        return entity;
    }

    public MonedaResponseDto toResponseDto(Moneda entity) {
        MonedaResponseDto dto = new MonedaResponseDto();
        dto.setId(entity.getId());
        dto.setNombre(entity.getNombre());
        dto.setFechaCreacion(entity.getFechaCreacion());
        dto.setFechaModificacion(entity.getFechaModificacion());
        return dto;
    }
}
