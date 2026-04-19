package com.ahumada.finanzaspersonales.cuenta;

import static org.junit.jupiter.api.Assertions.assertEquals;

import java.time.LocalDateTime;

import org.junit.jupiter.api.Test;

import com.ahumada.finanzaspersonales.usuario.Usuario;

class CuentaMapperTest {

    private final CuentaMapper mapper = new CuentaMapper();

    @Test
    void toEntity_requestAEntity() {
        CuentaRequestDto request = new CuentaRequestDto();
        request.setNombre("Cuenta test");
        request.setUsuarioId(22L);
        Usuario usuario = new Usuario(22L);

        Cuenta entity = mapper.toEntity(request, usuario);

        assertEquals("Cuenta test", entity.getNombre());
        assertEquals(22L, entity.getUsuario().getId());
    }

    @Test
    void toResponse_entityAResponse() {
        Cuenta cuenta = new Cuenta();
        cuenta.setId(5L);
        cuenta.setNombre("Caja");
        Usuario usuario = new Usuario();
        usuario.setId(9L);
        usuario.setNombre("Pepe");
        usuario.setFechaCreacion(LocalDateTime.now());
        usuario.setFechaModificacion(LocalDateTime.now());
        cuenta.setUsuario(usuario);

        CuentaResponseDto response = mapper.toResponseDto(cuenta);

        assertEquals(5L, response.getId());
        assertEquals("Caja", response.getNombre());
        assertEquals(9L, response.getUsuario().getId());
    }
}
