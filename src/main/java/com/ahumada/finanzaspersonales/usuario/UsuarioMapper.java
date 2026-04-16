package com.ahumada.finanzaspersonales.usuario;

public class UsuarioMapper {

    public Usuario toEntity(UsuarioRequestDto dto) {
        Usuario entity = new Usuario();
        entity.setNombre(dto.getNombre());
        return entity;
    }

    public UsuarioResponseDto toResponseDto(Usuario usuario) {
        UsuarioResponseDto dto = new UsuarioResponseDto();
        dto.setId(usuario.getId());
        dto.setNombre(usuario.getNombre());
        dto.setFechaCreacion(usuario.getFechaCreacion());
        dto.setFechaModificacion(usuario.getFechaModificacion());
        return dto;
    }
}
