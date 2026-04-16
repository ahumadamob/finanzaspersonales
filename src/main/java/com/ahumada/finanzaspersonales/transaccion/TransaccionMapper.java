package com.ahumada.finanzaspersonales.transaccion;

import com.ahumada.finanzaspersonales.common.ImporteMonetario;
import com.ahumada.finanzaspersonales.cuenta.Cuenta;
import com.ahumada.finanzaspersonales.itempresupuesto.ItemPresupuesto;

public class TransaccionMapper {

    public Transaccion toEntity(TransaccionRequestDto dto,
            ImporteMonetario importe,
            Cuenta cuenta,
            ItemPresupuesto itemPresupuesto) {
        Transaccion entity = new Transaccion();
        entity.setImporte(importe);
        entity.setFechaTransaccion(dto.getFechaTransaccion());
        entity.setCuenta(cuenta);
        entity.setItemPresupuesto(itemPresupuesto);
        return entity;
    }

    public TransaccionResponseDto toResponseDto(Transaccion entity) {
        TransaccionResponseDto dto = new TransaccionResponseDto();
        dto.setId(entity.getId());
        dto.setImporteId(entity.getImporte().getId());
        dto.setFechaTransaccion(entity.getFechaTransaccion());
        dto.setCuentaId(entity.getCuenta().getId());
        dto.setItemPresupuestoId(entity.getItemPresupuesto().getId());
        dto.setFechaCreacion(entity.getFechaCreacion());
        dto.setFechaModificacion(entity.getFechaModificacion());
        return dto;
    }
}
