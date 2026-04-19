package com.ahumada.finanzaspersonales.plazofijo;

import com.ahumada.finanzaspersonales.common.ImporteMonetario;
import com.ahumada.finanzaspersonales.cuenta.Cuenta;
import com.ahumada.finanzaspersonales.itempresupuesto.ItemPresupuesto;

public class PlazoFijoMapper {

    public PlazoFijo toEntity(PlazoFijoRequestDto dto,
            Cuenta cuenta,
            ImporteMonetario capitalInicial,
            ItemPresupuesto itemPresupuesto) {
        PlazoFijo entity = new PlazoFijo();
        entity.setCuenta(cuenta);
        entity.setCapitalInicial(capitalInicial);
        entity.setTasaNominalAnual(dto.getTasaNominalAnual());
        entity.setPlazoDias(dto.getPlazoDias());
        entity.setFechaConstitucion(dto.getFechaConstitucion());
        entity.setFechaVencimiento(dto.getFechaVencimiento());
        entity.setItemPresupuesto(itemPresupuesto);
        return entity;
    }

    public PlazoFijoResponseDto toResponseDto(PlazoFijo entity) {
        PlazoFijoResponseDto dto = new PlazoFijoResponseDto();
        dto.setId(entity.getId());
        dto.setCuentaId(entity.getCuenta().getId());
        dto.setCapitalInicialId(entity.getCapitalInicial().getId());
        dto.setTasaNominalAnual(entity.getTasaNominalAnual());
        dto.setPlazoDias(entity.getPlazoDias());
        dto.setFechaConstitucion(entity.getFechaConstitucion());
        dto.setFechaVencimiento(entity.getFechaVencimiento());
        dto.setItemPresupuestoId(entity.getItemPresupuesto().getId());
        dto.setFechaCreacion(entity.getFechaCreacion());
        dto.setFechaModificacion(entity.getFechaModificacion());
        return dto;
    }
}
