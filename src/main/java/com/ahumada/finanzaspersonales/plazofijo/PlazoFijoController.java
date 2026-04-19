package com.ahumada.finanzaspersonales.plazofijo;

import java.util.List;

import jakarta.validation.Valid;

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
@RequestMapping("/v1/plazo-fijo")
public class PlazoFijoController {

    private final PlazoFijoService plazoFijoService;
    private final PlazoFijoMapper plazoFijoMapper;

    public PlazoFijoController(PlazoFijoService plazoFijoService) {
        this.plazoFijoService = plazoFijoService;
        this.plazoFijoMapper = new PlazoFijoMapper();
    }

    @GetMapping
    public ResponseEntity<ApiResponseSuccessDto<List<PlazoFijoResponseDto>>> getAll() {
        List<PlazoFijoResponseDto> data = plazoFijoService.getAll().stream().map(plazoFijoMapper::toResponseDto).toList();
        return ResponseEntity.ok(success("Plazos fijos obtenidos correctamente", data));
    }

    @GetMapping("/{id}")
    public ResponseEntity<ApiResponseSuccessDto<PlazoFijoResponseDto>> getById(@PathVariable Long id) {
        PlazoFijoResponseDto data = plazoFijoMapper.toResponseDto(plazoFijoService.getById(id));
        return ResponseEntity.ok(success("Plazo fijo obtenido correctamente", data));
    }

    @PostMapping
    public ResponseEntity<ApiResponseSuccessDto<PlazoFijoResponseDto>> create(
            @Valid @RequestBody PlazoFijoRequestDto requestDto) {
        PlazoFijoResponseDto data = plazoFijoMapper.toResponseDto(plazoFijoService.save(requestDto));
        return ResponseEntity.ok(success("Plazo fijo creado correctamente", data));
    }

    @PutMapping("/{id}")
    public ResponseEntity<ApiResponseSuccessDto<PlazoFijoResponseDto>> update(@PathVariable Long id,
            @Valid @RequestBody PlazoFijoRequestDto requestDto) {
        PlazoFijoResponseDto data = plazoFijoMapper.toResponseDto(plazoFijoService.update(id, requestDto));
        return ResponseEntity.ok(success("Plazo fijo actualizado correctamente", data));
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<ApiResponseSuccessDto<Void>> delete(@PathVariable Long id) {
        plazoFijoService.deleteById(id);
        return ResponseEntity.ok(success("Plazo fijo eliminado correctamente", null));
    }

    private <T> ApiResponseSuccessDto<T> success(String message, T data) {
        return new ApiResponseSuccessDto<>(true, message, data);
    }
}
