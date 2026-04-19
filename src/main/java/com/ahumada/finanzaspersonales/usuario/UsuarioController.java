package com.ahumada.finanzaspersonales.usuario;

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

@RestController
@RequestMapping("/v1/usuario")
public class UsuarioController {

    private final UsuarioService usuarioService;
    private final UsuarioMapper usuarioMapper;

    public UsuarioController(UsuarioService usuarioService) {
        this.usuarioService = usuarioService;
        this.usuarioMapper = new UsuarioMapper();
    }

    @GetMapping
    public ResponseEntity<ApiResponseSuccessDto<List<UsuarioResponseDto>>> getAll() {
        List<UsuarioResponseDto> data = usuarioService.getAll().stream().map(usuarioMapper::toResponseDto).toList();
        return ResponseEntity.ok(success("Usuarios obtenidos correctamente", data));
    }

    @GetMapping("/{id}")
    public ResponseEntity<ApiResponseSuccessDto<UsuarioResponseDto>> getById(@PathVariable Long id) {
        UsuarioResponseDto data = usuarioMapper.toResponseDto(usuarioService.getById(id));
        return ResponseEntity.ok(success("Usuario obtenido correctamente", data));
    }

    @PostMapping
    public ResponseEntity<ApiResponseSuccessDto<UsuarioResponseDto>> create(@RequestBody UsuarioRequestDto requestDto) {
        UsuarioResponseDto data = usuarioMapper.toResponseDto(usuarioService.save(requestDto));
        return ResponseEntity.ok(success("Usuario creado correctamente", data));
    }

    @PutMapping("/{id}")
    public ResponseEntity<ApiResponseSuccessDto<UsuarioResponseDto>> update(@PathVariable Long id,
            @RequestBody UsuarioRequestDto requestDto) {
        Usuario usuario = usuarioService.getById(id);
        usuario.setNombre(requestDto.getNombre());

        UsuarioResponseDto data = usuarioMapper.toResponseDto(usuarioService.update(usuario));
        return ResponseEntity.ok(success("Usuario actualizado correctamente", data));
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<ApiResponseSuccessDto<Void>> delete(@PathVariable Long id) {
        usuarioService.deleteById(id);
        return ResponseEntity.ok(success("Usuario eliminado correctamente", null));
    }

    private <T> ApiResponseSuccessDto<T> success(String message, T data) {
        return new ApiResponseSuccessDto<>(true, message, data);
    }
}
