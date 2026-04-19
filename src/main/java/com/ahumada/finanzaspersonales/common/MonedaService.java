package com.ahumada.finanzaspersonales.common;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.ahumada.finanzaspersonales.common.exception.ResourceNotFoundException;

@Service
public class MonedaService {

    @Autowired
    private MonedaRepository repo;

    public List<Moneda> getAll() {
        return repo.findAllByOrderByNombreAsc();
    }

    public Moneda getById(Long id) {
        return repo.findById(id)
                .orElseThrow(() -> new ResourceNotFoundException(
                        "Moneda con id: " + id + " no encontrada."));
    }

    public Moneda save(Moneda moneda) {
        return repo.save(moneda);
    }

    public Moneda save(MonedaRequestDto dto) {
        MonedaMapper mapper = new MonedaMapper();
        Moneda entity = mapper.toEntity(dto);
        return repo.save(entity);
    }

    public Moneda update(Moneda moneda) {
        return repo.save(moneda);
    }

    public Moneda update(Long id, MonedaRequestDto dto) {
        Moneda moneda = this.getById(id);
        moneda.setNombre(dto.getNombre());
        return repo.save(moneda);
    }

    public void deleteById(Long id) {
        Moneda moneda = this.getById(id);
        repo.delete(moneda);
    }
}
