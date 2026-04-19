package com.ahumada.finanzaspersonales.transaccion;

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

import com.ahumada.finanzaspersonales.common.ImporteMonetarioService;
import com.ahumada.finanzaspersonales.common.dto.ApiResponseSuccessDto;
import com.ahumada.finanzaspersonales.cuenta.CuentaService;
import com.ahumada.finanzaspersonales.itempresupuesto.ItemPresupuestoService;

@RestController
@RequestMapping("/v1/transaccion")
public class TransaccionController {

    private final TransaccionService transaccionService;
    private final ImporteMonetarioService importeMonetarioService;
    private final CuentaService cuentaService;
    private final ItemPresupuestoService itemPresupuestoService;
    private final TransaccionMapper transaccionMapper;

    public TransaccionController(TransaccionService transaccionService,
            ImporteMonetarioService importeMonetarioService,
            CuentaService cuentaService,
            ItemPresupuestoService itemPresupuestoService) {
        this.transaccionService = transaccionService;
        this.importeMonetarioService = importeMonetarioService;
        this.cuentaService = cuentaService;
        this.itemPresupuestoService = itemPresupuestoService;
        this.transaccionMapper = new TransaccionMapper();
    }

    @GetMapping
    public ResponseEntity<ApiResponseSuccessDto<List<TransaccionResponseDto>>> getAll() {
        List<TransaccionResponseDto> data = transaccionService.getAll().stream().map(transaccionMapper::toResponseDto)
                .toList();
        return ResponseEntity.ok(success("Transacciones obtenidas correctamente", data));
    }

    @GetMapping("/{id}")
    public ResponseEntity<ApiResponseSuccessDto<TransaccionResponseDto>> getById(@PathVariable Long id) {
        TransaccionResponseDto data = transaccionMapper.toResponseDto(transaccionService.getById(id));
        return ResponseEntity.ok(success("Transaccion obtenida correctamente", data));
    }

    @PostMapping
    public ResponseEntity<ApiResponseSuccessDto<TransaccionResponseDto>> create(
            @RequestBody TransaccionRequestDto requestDto) {
        TransaccionResponseDto data = transaccionMapper.toResponseDto(transaccionService.save(requestDto));
        return ResponseEntity.ok(success("Transaccion creada correctamente", data));
    }

    @PutMapping("/{id}")
    public ResponseEntity<ApiResponseSuccessDto<TransaccionResponseDto>> update(@PathVariable Long id,
            @RequestBody TransaccionRequestDto requestDto) {
        Transaccion transaccion = transaccionService.getById(id);
        transaccion.setImporte(importeMonetarioService.getById(requestDto.getImporteId()));
        transaccion.setFechaTransaccion(requestDto.getFechaTransaccion());
        transaccion.setCuenta(cuentaService.getById(requestDto.getCuentaId()));
        transaccion.setItemPresupuesto(itemPresupuestoService.getById(requestDto.getItemPresupuestoId()));

        TransaccionResponseDto data = transaccionMapper.toResponseDto(transaccionService.update(transaccion));
        return ResponseEntity.ok(success("Transaccion actualizada correctamente", data));
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<ApiResponseSuccessDto<Void>> delete(@PathVariable Long id) {
        transaccionService.deleteById(id);
        return ResponseEntity.ok(success("Transaccion eliminada correctamente", null));
    }

    private <T> ApiResponseSuccessDto<T> success(String message, T data) {
        return new ApiResponseSuccessDto<>(true, message, data);
    }
}
