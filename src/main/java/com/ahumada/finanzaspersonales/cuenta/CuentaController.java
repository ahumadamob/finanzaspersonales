package com.ahumada.finanzaspersonales.cuenta;

import java.util.List;
import java.util.stream.Collectors;

import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.ahumada.finanzaspersonales.common.dto.ApiResponseSuccessDto;
import com.ahumada.finanzaspersonales.usuario.Usuario;

@RestController
@RequestMapping("/v1/cuenta")
public class CuentaController {
	
	private CuentaService cuentaService;
	
	@GetMapping("/{usuario_id}")
	public ResponseEntity<ApiResponseSuccessDto<List<CuentaResponseDto>>> getAll(@PathVariable Long usuarioId){
		
		Usuario usuario = new Usuario(usuarioId);
		CuentaMapper mapper = new CuentaMapper();
		
		List<Cuenta> cuentas = cuentaService.getAll(usuario);
		
		List<CuentaResponseDto> cuentasDto = cuentas.stream()
				.map(mapper::toResponseDto)
				.collect(Collectors.toList());
		
		ApiResponseSuccessDto<List<CuentaResponseDto>> response = new ApiResponseSuccessDto<List<CuentaResponseDto>>();
		response.setSuccess(true);
		response.setMessage("Cuentas obtenidas correctamente");
		response.setData(cuentasDto);
		
		return ResponseEntity.ok(response);
	}

}
