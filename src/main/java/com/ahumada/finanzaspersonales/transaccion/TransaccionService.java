package com.ahumada.finanzaspersonales.transaccion;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.ahumada.finanzaspersonales.common.ImporteMonetario;
import com.ahumada.finanzaspersonales.common.ImporteMonetarioService;
import com.ahumada.finanzaspersonales.common.exception.ResourceNotFoundException;
import com.ahumada.finanzaspersonales.cuenta.Cuenta;
import com.ahumada.finanzaspersonales.cuenta.CuentaService;
import com.ahumada.finanzaspersonales.itempresupuesto.ItemPresupuesto;
import com.ahumada.finanzaspersonales.itempresupuesto.ItemPresupuestoService;

@Service
public class TransaccionService {

    @Autowired
    private TransaccionRepository repo;

    @Autowired
    private ImporteMonetarioService importeMonetarioService;

    @Autowired
    private CuentaService cuentaService;

    @Autowired
    private ItemPresupuestoService itemPresupuestoService;

    public List<Transaccion> getAll() {
        return repo.findAllByOrderByFechaTransaccionDesc();
    }

    public Transaccion getById(Long id) {
        return repo.findByIdTransaccion(id)
                .orElseThrow(() -> new ResourceNotFoundException(
                        "Transaccion con id: " + id + " no encontrada."));
    }

    public Transaccion save(Transaccion transaccion) {
        return repo.save(transaccion);
    }

    public Transaccion save(TransaccionRequestDto dto) {
        TransaccionMapper mapper = new TransaccionMapper();
        ImporteMonetario importe = importeMonetarioService.getById(dto.getImporteId());
        Cuenta cuenta = cuentaService.getById(dto.getCuentaId());
        ItemPresupuesto itemPresupuesto = itemPresupuestoService.getById(dto.getItemPresupuestoId());
        Transaccion entity = mapper.toEntity(dto, importe, cuenta, itemPresupuesto);
        return repo.save(entity);
    }

    public Transaccion update(Transaccion transaccion) {
        return repo.save(transaccion);
    }

    public Transaccion update(Long id, TransaccionRequestDto dto) {
        Transaccion transaccion = this.getById(id);
        transaccion.setImporte(importeMonetarioService.getById(dto.getImporteId()));
        transaccion.setFechaTransaccion(dto.getFechaTransaccion());
        transaccion.setCuenta(cuentaService.getById(dto.getCuentaId()));
        transaccion.setItemPresupuesto(itemPresupuestoService.getById(dto.getItemPresupuestoId()));
        return repo.save(transaccion);
    }

    public void deleteById(Long id) {
        Transaccion transaccion = this.getById(id);
        repo.delete(transaccion);
    }
}
