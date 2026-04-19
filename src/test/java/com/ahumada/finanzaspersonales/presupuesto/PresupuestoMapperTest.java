package com.ahumada.finanzaspersonales.presupuesto;

import static org.junit.jupiter.api.Assertions.assertEquals;

import java.time.LocalDateTime;
import java.time.YearMonth;

import org.junit.jupiter.api.Test;

class PresupuestoMapperTest {

    private final PresupuestoMapper mapper = new PresupuestoMapper();

    @Test
    void toEntity_requestAEntity() {
        PresupuestoRequestDto request = new PresupuestoRequestDto();
        request.setPeriodo(YearMonth.of(2026, 4));
        request.setEstado(EstadoPresupuesto.VIGENTE);

        Presupuesto entity = mapper.toEntity(request);

        assertEquals(YearMonth.of(2026, 4), entity.getPeriodo());
        assertEquals(EstadoPresupuesto.VIGENTE, entity.getEstado());
    }

    @Test
    void toResponse_entityAResponse() {
        Presupuesto entity = new Presupuesto();
        entity.setId(9L);
        entity.setPeriodo(YearMonth.of(2026, 7));
        entity.setVersion(2);
        entity.setEstado(EstadoPresupuesto.CERRADO);
        entity.setFechaCreacion(LocalDateTime.now());
        entity.setFechaModificacion(LocalDateTime.now());

        PresupuestoResponseDto response = mapper.toResponseDto(entity);

        assertEquals(9L, response.getId());
        assertEquals(YearMonth.of(2026, 7), response.getPeriodo());
        assertEquals(2, response.getVersion());
    }
}
