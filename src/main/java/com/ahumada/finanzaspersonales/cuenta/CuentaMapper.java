package com.ahumada.finanzaspersonales.cuenta;

import com.ahumada.finanzaspersonales.usuario.UsuarioMapper;

public class CuentaMapper {

	public CuentaResponseDto toResponseDto(Cuenta cuenta) {
		
		CuentaResponseDto dto = new CuentaResponseDto();
		UsuarioMapper usuarioMapper = new UsuarioMapper();
		
		dto.setId(cuenta.getId());
		dto.setNombre(cuenta.getNombre());		
		dto.setUsuario(usuarioMapper.toResponseDto(cuenta.getUsuario()));
		dto.setFechaCreacion(cuenta.getFechaCreacion());
		dto.setFechaModificacion(cuenta.getFechaModificacion());
		
		return dto;
	}
}
