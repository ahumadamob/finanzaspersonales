package com.ahumada.finanzaspersonales.cuenta;

import java.util.List;

import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.ahumada.finanzaspersonales.common.dto.ApiResponseSuccessDto;
import com.ahumada.finanzaspersonales.usuario.Usuario;
import com.ahumada.finanzaspersonales.usuario.UsuarioService;

@RestController
@RequestMapping("/v1/cuenta")
public class CuentaController {

    private final CuentaService cuentaService;
    private final UsuarioService usuarioService;
    private final CuentaMapper cuentaMapper;

    public CuentaController(CuentaService cuentaService, UsuarioService usuarioService) {
        this.cuentaService = cuentaService;
        this.usuarioService = usuarioService;
        this.cuentaMapper = new CuentaMapper();
    }

    @GetMapping
    public ResponseEntity<ApiResponseSuccessDto<List<CuentaResponseDto>>> getAll() {
        List<CuentaResponseDto> data = cuentaService.getAll().stream().map(cuentaMapper::toResponseDto).toList();
        return ResponseEntity.ok(success("Cuentas obtenidas correctamente", data));
    }

    @GetMapping("/usuario/{usuarioId}")
    public ResponseEntity<ApiResponseSuccessDto<List<CuentaResponseDto>>> getAllByUsuario(
            @PathVariable Long usuarioId) {
        Usuario usuario = usuarioService.getById(usuarioId);
        List<CuentaResponseDto> data = cuentaService.getAllByUsuario(usuario).stream().map(cuentaMapper::toResponseDto)
                .toList();
        return ResponseEntity.ok(success("Cuentas obtenidas correctamente", data));
    }

    @GetMapping("/{id}")
    public ResponseEntity<ApiResponseSuccessDto<CuentaResponseDto>> getById(@PathVariable Long id) {
        CuentaResponseDto data = cuentaMapper.toResponseDto(cuentaService.getById(id));
        return ResponseEntity.ok(success("Cuenta obtenida correctamente", data));
    }

    @PostMapping
    public ResponseEntity<ApiResponseSuccessDto<CuentaResponseDto>> create(@RequestBody CuentaRequestDto requestDto) {
        CuentaResponseDto data = cuentaMapper.toResponseDto(cuentaService.save(requestDto));
        return ResponseEntity.ok(success("Cuenta creada correctamente", data));
    }

    @PutMapping("/{id}")
    public ResponseEntity<ApiResponseSuccessDto<CuentaResponseDto>> update(@PathVariable Long id,
            @RequestBody CuentaRequestDto requestDto) {
        Cuenta cuenta = cuentaService.getById(id);
        cuenta.setNombre(requestDto.getNombre());
        cuenta.setUsuario(usuarioService.getById(requestDto.getUsuarioId()));

        CuentaResponseDto data = cuentaMapper.toResponseDto(cuentaService.update(cuenta));
        return ResponseEntity.ok(success("Cuenta actualizada correctamente", data));
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<ApiResponseSuccessDto<Void>> delete(@PathVariable Long id) {
        cuentaService.deleteById(id);
        return ResponseEntity.ok(success("Cuenta eliminada correctamente", null));
    }

    private <T> ApiResponseSuccessDto<T> success(String message, T data) {
        return new ApiResponseSuccessDto<>(true, message, data);
    }
}
