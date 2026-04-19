package com.ahumada.finanzaspersonales.common;

import static org.junit.jupiter.api.Assertions.assertEquals;

import java.time.LocalDateTime;

import org.junit.jupiter.api.Test;

class MonedaMapperTest {

    private final MonedaMapper mapper = new MonedaMapper();

    @Test
    void toEntity_requestAEntity() {
        MonedaRequestDto request = new MonedaRequestDto();
        request.setNombre("ARS");

        Moneda entity = mapper.toEntity(request);

        assertEquals("ARS", entity.getNombre());
    }

    @Test
    void toResponse_entityAResponse() {
        Moneda moneda = new Moneda();
        moneda.setId(1L);
        moneda.setNombre("USD");
        moneda.setFechaCreacion(LocalDateTime.now());
        moneda.setFechaModificacion(LocalDateTime.now());

        MonedaResponseDto response = mapper.toResponseDto(moneda);

        assertEquals(1L, response.getId());
        assertEquals("USD", response.getNombre());
    }
}
