package com.ahumada.finanzaspersonales.itempresupuesto;

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
@RequestMapping("/v1/item-presupuesto")
public class ItemPresupuestoController {

    private final ItemPresupuestoService itemService;
    private final ItemPresupuestoMapper itemMapper;

    public ItemPresupuestoController(ItemPresupuestoService itemService) {
        this.itemService = itemService;
        this.itemMapper = new ItemPresupuestoMapper();
    }

    @GetMapping
    public ResponseEntity<ApiResponseSuccessDto<List<ItemPresupuestoResponseDto>>> getAll() {
        List<ItemPresupuestoResponseDto> data = itemService.getAll().stream().map(itemMapper::toResponseDto).toList();
        return ResponseEntity.ok(success("Items de presupuesto obtenidos correctamente", data));
    }

    @GetMapping("/{id}")
    public ResponseEntity<ApiResponseSuccessDto<ItemPresupuestoResponseDto>> getById(@PathVariable Long id) {
        ItemPresupuestoResponseDto data = itemMapper.toResponseDto(itemService.getById(id));
        return ResponseEntity.ok(success("Item de presupuesto obtenido correctamente", data));
    }

    @PostMapping
    public ResponseEntity<ApiResponseSuccessDto<ItemPresupuestoResponseDto>> create(
            @Valid @RequestBody ItemPresupuestoRequestDto requestDto) {
        ItemPresupuestoResponseDto data = itemMapper.toResponseDto(itemService.save(requestDto));
        return ResponseEntity.ok(success("Item de presupuesto creado correctamente", data));
    }

    @PutMapping("/{id}")
    public ResponseEntity<ApiResponseSuccessDto<ItemPresupuestoResponseDto>> update(@PathVariable Long id,
            @Valid @RequestBody ItemPresupuestoRequestDto requestDto) {
        ItemPresupuestoResponseDto data = itemMapper.toResponseDto(itemService.update(id, requestDto));
        return ResponseEntity.ok(success("Item de presupuesto actualizado correctamente", data));
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<ApiResponseSuccessDto<Void>> delete(@PathVariable Long id) {
        itemService.deleteById(id);
        return ResponseEntity.ok(success("Item de presupuesto eliminado correctamente", null));
    }

    private <T> ApiResponseSuccessDto<T> success(String message, T data) {
        return new ApiResponseSuccessDto<>(true, message, data);
    }
}
