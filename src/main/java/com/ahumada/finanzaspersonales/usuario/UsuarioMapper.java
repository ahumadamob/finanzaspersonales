package com.ahumada.finanzaspersonales.usuario;

public class UsuarioMapper {
	
	public UsuarioResponseDto toResponseDto(Usuario usuario) {
		UsuarioResponseDto dto = new UsuarioResponseDto();
		dto.setId(usuario.getId());
		dto.setNombre(usuario.getNombre());
		dto.setFechaCreacion(usuario.getFechaCreacion());
		dto.setFechaModificacion(usuario.getFechaModificacion());
		return dto;
	}

}
