package com.ahumada.finanzaspersonales.common;

public class ImporteMonetarioMapper {

    public ImporteMonetario toEntity(ImporteMonetarioRequestDto dto, Moneda moneda) {
        ImporteMonetario entity = new ImporteMonetario();
        entity.setMoneda(moneda);
        entity.setMonto(dto.getMonto());
        return entity;
    }

    public ImporteMonetarioResponseDto toResponseDto(ImporteMonetario entity) {
        ImporteMonetarioResponseDto dto = new ImporteMonetarioResponseDto();
        dto.setId(entity.getId());
        dto.setMonedaId(entity.getMoneda().getId());
        dto.setMonto(entity.getMonto());
        dto.setFechaCreacion(entity.getFechaCreacion());
        dto.setFechaModificacion(entity.getFechaModificacion());
        return dto;
    }
}
