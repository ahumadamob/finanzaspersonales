package com.ahumada.finanzaspersonales.plazofijo;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.ahumada.finanzaspersonales.common.exception.ResourceNotFoundException;

@Service
public class PlazoFijoService {

    @Autowired
    private PlazoFijoRepository repo;

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

    public PlazoFijo update(PlazoFijo plazoFijo) {
        return repo.save(plazoFijo);
    }

    public void deleteById(Long id) {
        PlazoFijo plazoFijo = this.getById(id);
        repo.delete(plazoFijo);
    }
}
