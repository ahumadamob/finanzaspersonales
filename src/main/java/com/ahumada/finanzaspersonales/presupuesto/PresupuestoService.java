package com.ahumada.finanzaspersonales.presupuesto;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.ahumada.finanzaspersonales.common.exception.ResourceNotFoundException;

@Service
public class PresupuestoService {

    @Autowired
    private PresupuestoRepository repo;

    public List<Presupuesto> getAll() {
        return repo.findAllByOrderByPeriodoAsc();
    }

    public Presupuesto getById(Long id) {
        return repo.findByIdPresupuesto(id)
                .orElseThrow(() -> new ResourceNotFoundException(
                        "Presupuesto con id: " + id + " no encontrado."));
    }

    public Presupuesto save(Presupuesto presupuesto) {
        return repo.save(presupuesto);
    }

    public Presupuesto update(Presupuesto presupuesto) {
        return repo.save(presupuesto);
    }

    public void deleteById(Long id) {
        Presupuesto presupuesto = this.getById(id);
        repo.delete(presupuesto);
    }
}
