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
@RequestMapping("/v1/importe-monetario")
public class ImporteMonetarioController {

    private final ImporteMonetarioService importeMonetarioService;
    private final MonedaService monedaService;
    private final ImporteMonetarioMapper importeMonetarioMapper;

    public ImporteMonetarioController(ImporteMonetarioService importeMonetarioService, MonedaService monedaService) {
        this.importeMonetarioService = importeMonetarioService;
        this.monedaService = monedaService;
        this.importeMonetarioMapper = new ImporteMonetarioMapper();
    }

    @GetMapping
    public ResponseEntity<ApiResponseSuccessDto<List<ImporteMonetarioResponseDto>>> getAll() {
        List<ImporteMonetarioResponseDto> data = importeMonetarioService.getAll().stream()
                .map(importeMonetarioMapper::toResponseDto).toList();
        return ResponseEntity.ok(success("Importes monetarios obtenidos correctamente", data));
    }

    @GetMapping("/{id}")
    public ResponseEntity<ApiResponseSuccessDto<ImporteMonetarioResponseDto>> getById(@PathVariable Long id) {
        ImporteMonetarioResponseDto data = importeMonetarioMapper.toResponseDto(importeMonetarioService.getById(id));
        return ResponseEntity.ok(success("Importe monetario obtenido correctamente", data));
    }

    @PostMapping
    public ResponseEntity<ApiResponseSuccessDto<ImporteMonetarioResponseDto>> create(
            @RequestBody ImporteMonetarioRequestDto requestDto) {
        ImporteMonetarioResponseDto data = importeMonetarioMapper.toResponseDto(importeMonetarioService.save(requestDto));
        return ResponseEntity.ok(success("Importe monetario creado correctamente", data));
    }

    @PutMapping("/{id}")
    public ResponseEntity<ApiResponseSuccessDto<ImporteMonetarioResponseDto>> update(@PathVariable Long id,
            @RequestBody ImporteMonetarioRequestDto requestDto) {
        ImporteMonetario importeMonetario = importeMonetarioService.getById(id);
        importeMonetario.setMoneda(monedaService.getById(requestDto.getMonedaId()));
        importeMonetario.setMonto(requestDto.getMonto());

        ImporteMonetarioResponseDto data = importeMonetarioMapper.toResponseDto(importeMonetarioService.update(importeMonetario));
        return ResponseEntity.ok(success("Importe monetario actualizado correctamente", data));
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<ApiResponseSuccessDto<Void>> delete(@PathVariable Long id) {
        importeMonetarioService.deleteById(id);
        return ResponseEntity.ok(success("Importe monetario eliminado correctamente", null));
    }

    private <T> ApiResponseSuccessDto<T> success(String message, T data) {
        return new ApiResponseSuccessDto<>(true, message, data);
    }
}
