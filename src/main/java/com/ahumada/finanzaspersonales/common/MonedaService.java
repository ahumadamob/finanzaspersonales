package com.ahumada.finanzaspersonales.common;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.ahumada.finanzaspersonales.common.exception.ResourceNotFoundException;

@Service
public class MonedaService {

    @Autowired
    private MonedaRepository repo;

    public Moneda getById(Long id) {
        return repo.findById(id)
                .orElseThrow(() -> new ResourceNotFoundException(
                        "Moneda con id: " + id + " no encontrada."));
    }

    public Moneda save(Moneda moneda) {
        return repo.save(moneda);
    }
}
