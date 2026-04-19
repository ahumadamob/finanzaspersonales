package com.ahumada.finanzaspersonales.usuario;

import static org.junit.jupiter.api.Assertions.assertEquals;

import java.time.LocalDateTime;

import org.junit.jupiter.api.Test;

class UsuarioMapperTest {

    private final UsuarioMapper mapper = new UsuarioMapper();

    @Test
    void toEntity_requestAEntity() {
        UsuarioRequestDto request = new UsuarioRequestDto();
        request.setNombre("Ana");

        Usuario entity = mapper.toEntity(request);

        assertEquals("Ana", entity.getNombre());
    }

    @Test
    void toResponse_entityAResponse() {
        Usuario usuario = new Usuario();
        usuario.setId(2L);
        usuario.setNombre("Ana");
        usuario.setFechaCreacion(LocalDateTime.now());
        usuario.setFechaModificacion(LocalDateTime.now());

        UsuarioResponseDto response = mapper.toResponseDto(usuario);

        assertEquals(2L, response.getId());
        assertEquals("Ana", response.getNombre());
    }
}
