package com.ahumada.finanzaspersonales.presupuesto;

public class PresupuestoMapper {

    public Presupuesto toEntity(PresupuestoRequestDto dto) {
        Presupuesto entity = new Presupuesto();
        entity.setPeriodo(dto.getPeriodo());
        entity.setEstado(dto.getEstado());
        return entity;
    }

    public PresupuestoResponseDto toResponseDto(Presupuesto entity) {
        PresupuestoResponseDto dto = new PresupuestoResponseDto();
        dto.setId(entity.getId());
        dto.setPeriodo(entity.getPeriodo());
        dto.setVersion(entity.getVersion());
        dto.setEstado(entity.getEstado());
        dto.setFechaCreacion(entity.getFechaCreacion());
        dto.setFechaModificacion(entity.getFechaModificacion());
        return dto;
    }
}
