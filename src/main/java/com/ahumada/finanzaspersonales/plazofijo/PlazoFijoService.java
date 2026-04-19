package com.ahumada.finanzaspersonales.plazofijo;

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
public class PlazoFijoService {

    @Autowired
    private PlazoFijoRepository repo;

    @Autowired
    private CuentaService cuentaService;

    @Autowired
    private ImporteMonetarioService importeMonetarioService;

    @Autowired
    private ItemPresupuestoService itemPresupuestoService;

    public List<PlazoFijo> getAll() {
        return repo.findAllByOrderByFechaVencimientoAsc();
    }

    public PlazoFijo getById(Long id) {
        return repo.findByIdPlazoFijo(id)
                .orElseThrow(() -> new ResourceNotFoundException(
                        "PlazoFijo con id: " + id + " no encontrado."));
    }

    public PlazoFijo save(PlazoFijo plazoFijo) {
        return repo.save(plazoFijo);
    }

    public PlazoFijo save(PlazoFijoRequestDto dto) {
        PlazoFijoMapper mapper = new PlazoFijoMapper();
        Cuenta cuenta = cuentaService.getById(dto.getCuentaId());
        ImporteMonetario capitalInicial = importeMonetarioService.getById(dto.getCapitalInicialId());
        ItemPresupuesto itemPresupuesto = itemPresupuestoService.getById(dto.getItemPresupuestoId());
        PlazoFijo entity = mapper.toEntity(dto, cuenta, capitalInicial, itemPresupuesto);
        return repo.save(entity);
    }

    public PlazoFijo update(PlazoFijo plazoFijo) {
        return repo.save(plazoFijo);
    }

    public PlazoFijo update(Long id, PlazoFijoRequestDto dto) {
        PlazoFijo plazoFijo = this.getById(id);
        plazoFijo.setCuenta(cuentaService.getById(dto.getCuentaId()));
        plazoFijo.setCapitalInicial(importeMonetarioService.getById(dto.getCapitalInicialId()));
        plazoFijo.setTasaNominalAnual(dto.getTasaNominalAnual());
        plazoFijo.setPlazoDias(dto.getPlazoDias());
        plazoFijo.setFechaConstitucion(dto.getFechaConstitucion());
        plazoFijo.setFechaVencimiento(dto.getFechaVencimiento());
        plazoFijo.setItemPresupuesto(itemPresupuestoService.getById(dto.getItemPresupuestoId()));
        return repo.save(plazoFijo);
    }

    public void deleteById(Long id) {
        PlazoFijo plazoFijo = this.getById(id);
        repo.delete(plazoFijo);
    }
}
