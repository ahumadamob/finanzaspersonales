package com.ahumada.finanzaspersonales.categoriaitempresupuesto;

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
@RequestMapping("/v1/categoria-item-presupuesto")
public class CategoriaItemPresupuestoController {

    private final CategoriaItemPresupuestoService categoriaService;
    private final CategoriaItemPresupuestoMapper categoriaMapper;

    public CategoriaItemPresupuestoController(CategoriaItemPresupuestoService categoriaService) {
        this.categoriaService = categoriaService;
        this.categoriaMapper = new CategoriaItemPresupuestoMapper();
    }

    @GetMapping
    public ResponseEntity<ApiResponseSuccessDto<List<CategoriaItemPresupuestoResponseDto>>> getAll() {
        List<CategoriaItemPresupuestoResponseDto> data = categoriaService.getAll().stream()
                .map(categoriaMapper::toResponseDto)
                .toList();
        return ResponseEntity.ok(success("Categorias de item presupuesto obtenidas correctamente", data));
    }

    @GetMapping("/{id}")
    public ResponseEntity<ApiResponseSuccessDto<CategoriaItemPresupuestoResponseDto>> getById(@PathVariable Long id) {
        CategoriaItemPresupuestoResponseDto data = categoriaMapper.toResponseDto(categoriaService.getById(id));
        return ResponseEntity.ok(success("Categoria de item presupuesto obtenida correctamente", data));
    }

    @PostMapping
    public ResponseEntity<ApiResponseSuccessDto<CategoriaItemPresupuestoResponseDto>> create(
            @Valid @RequestBody CategoriaItemPresupuestoRequestDto requestDto) {
        CategoriaItemPresupuestoResponseDto data = categoriaMapper.toResponseDto(categoriaService.save(requestDto));
        return ResponseEntity.ok(success("Categoria de item presupuesto creada correctamente", data));
    }

    @PutMapping("/{id}")
    public ResponseEntity<ApiResponseSuccessDto<CategoriaItemPresupuestoResponseDto>> update(@PathVariable Long id,
            @Valid @RequestBody CategoriaItemPresupuestoRequestDto requestDto) {
        CategoriaItemPresupuestoResponseDto data = categoriaMapper.toResponseDto(categoriaService.update(id, requestDto));
        return ResponseEntity.ok(success("Categoria de item presupuesto actualizada correctamente", data));
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<ApiResponseSuccessDto<Void>> delete(@PathVariable Long id) {
        categoriaService.deleteById(id);
        return ResponseEntity.ok(success("Categoria de item presupuesto eliminada correctamente", null));
    }

    private <T> ApiResponseSuccessDto<T> success(String message, T data) {
        return new ApiResponseSuccessDto<>(true, message, data);
    }
}
