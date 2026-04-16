package com.ahumada.finanzaspersonales.itempresupuesto;

import com.ahumada.finanzaspersonales.categoriaitempresupuesto.CategoriaItemPresupuesto;
import com.ahumada.finanzaspersonales.common.ImporteMonetario;

public class ItemPresupuestoMapper {

    public ItemPresupuesto toEntity(ItemPresupuestoRequestDto dto,
            CategoriaItemPresupuesto categoria,
            ImporteMonetario importeMonetario) {
        ItemPresupuesto entity = new ItemPresupuesto();
        entity.setCategoria(categoria);
        entity.setImporteMonetario(importeMonetario);
        entity.setFechaVencimiento(dto.getFechaVencimiento());
        entity.setConsolidado(dto.isConsolidado());
        entity.setItemReferenciaId(dto.getItemReferenciaId());
        return entity;
    }

    public ItemPresupuestoResponseDto toResponseDto(ItemPresupuesto entity) {
        ItemPresupuestoResponseDto dto = new ItemPresupuestoResponseDto();
        dto.setId(entity.getId());
        dto.setCategoriaId(entity.getCategoria().getId());
        dto.setImporteMonetarioId(entity.getImporteMonetario().getId());
        dto.setFechaVencimiento(entity.getFechaVencimiento());
        dto.setConsolidado(entity.isConsolidado());
        dto.setItemReferenciaId(entity.getItemReferenciaId());
        dto.setFechaCreacion(entity.getFechaCreacion());
        dto.setFechaModificacion(entity.getFechaModificacion());
        return dto;
    }
}
