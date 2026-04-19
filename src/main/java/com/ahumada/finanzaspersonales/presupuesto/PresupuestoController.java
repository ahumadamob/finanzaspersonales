package com.ahumada.finanzaspersonales.presupuesto;

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
@RequestMapping("/v1/presupuesto")
public class PresupuestoController {

    private final PresupuestoService presupuestoService;
    private final PresupuestoMapper presupuestoMapper;

    public PresupuestoController(PresupuestoService presupuestoService) {
        this.presupuestoService = presupuestoService;
        this.presupuestoMapper = new PresupuestoMapper();
    }

    @GetMapping
    public ResponseEntity<ApiResponseSuccessDto<List<PresupuestoResponseDto>>> getAll() {
        List<PresupuestoResponseDto> data = presupuestoService.getAll().stream().map(presupuestoMapper::toResponseDto)
                .toList();
        return ResponseEntity.ok(success("Presupuestos obtenidos correctamente", data));
    }

    @GetMapping("/{id}")
    public ResponseEntity<ApiResponseSuccessDto<PresupuestoResponseDto>> getById(@PathVariable Long id) {
        PresupuestoResponseDto data = presupuestoMapper.toResponseDto(presupuestoService.getById(id));
        return ResponseEntity.ok(success("Presupuesto obtenido correctamente", data));
    }

    @PostMapping
    public ResponseEntity<ApiResponseSuccessDto<PresupuestoResponseDto>> create(
            @RequestBody PresupuestoRequestDto requestDto) {
        PresupuestoResponseDto data = presupuestoMapper.toResponseDto(presupuestoService.save(requestDto));
        return ResponseEntity.ok(success("Presupuesto creado correctamente", data));
    }

    @PutMapping("/{id}")
    public ResponseEntity<ApiResponseSuccessDto<PresupuestoResponseDto>> update(@PathVariable Long id,
            @RequestBody PresupuestoRequestDto requestDto) {
        Presupuesto presupuesto = presupuestoService.getById(id);
        presupuesto.setPeriodo(requestDto.getPeriodo());
        presupuesto.setEstado(requestDto.getEstado());

        PresupuestoResponseDto data = presupuestoMapper.toResponseDto(presupuestoService.update(presupuesto));
        return ResponseEntity.ok(success("Presupuesto actualizado correctamente", data));
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<ApiResponseSuccessDto<Void>> delete(@PathVariable Long id) {
        presupuestoService.deleteById(id);
        return ResponseEntity.ok(success("Presupuesto eliminado correctamente", null));
    }

    private <T> ApiResponseSuccessDto<T> success(String message, T data) {
        return new ApiResponseSuccessDto<>(true, message, data);
    }
}
