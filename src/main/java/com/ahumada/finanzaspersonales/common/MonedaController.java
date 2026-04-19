package com.ahumada.finanzaspersonales.common;

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
@RequestMapping("/v1/moneda")
public class MonedaController {

    private final MonedaService monedaService;
    private final MonedaMapper monedaMapper;

    public MonedaController(MonedaService monedaService) {
        this.monedaService = monedaService;
        this.monedaMapper = new MonedaMapper();
    }

    @GetMapping
    public ResponseEntity<ApiResponseSuccessDto<List<MonedaResponseDto>>> getAll() {
        List<MonedaResponseDto> data = monedaService.getAll().stream().map(monedaMapper::toResponseDto).toList();
        return ResponseEntity.ok(success("Monedas obtenidas correctamente", data));
    }

    @GetMapping("/{id}")
    public ResponseEntity<ApiResponseSuccessDto<MonedaResponseDto>> getById(@PathVariable Long id) {
        MonedaResponseDto data = monedaMapper.toResponseDto(monedaService.getById(id));
        return ResponseEntity.ok(success("Moneda obtenida correctamente", data));
    }

    @PostMapping
    public ResponseEntity<ApiResponseSuccessDto<MonedaResponseDto>> create(@RequestBody MonedaRequestDto requestDto) {
        MonedaResponseDto data = monedaMapper.toResponseDto(monedaService.save(requestDto));
        return ResponseEntity.ok(success("Moneda creada correctamente", data));
    }

    @PutMapping("/{id}")
    public ResponseEntity<ApiResponseSuccessDto<MonedaResponseDto>> update(@PathVariable Long id,
            @RequestBody MonedaRequestDto requestDto) {
        Moneda moneda = monedaService.getById(id);
        moneda.setNombre(requestDto.getNombre());

        MonedaResponseDto data = monedaMapper.toResponseDto(monedaService.update(moneda));
        return ResponseEntity.ok(success("Moneda actualizada correctamente", data));
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<ApiResponseSuccessDto<Void>> delete(@PathVariable Long id) {
        monedaService.deleteById(id);
        return ResponseEntity.ok(success("Moneda eliminada correctamente", null));
    }

    private <T> ApiResponseSuccessDto<T> success(String message, T data) {
        return new ApiResponseSuccessDto<>(true, message, data);
    }
}
