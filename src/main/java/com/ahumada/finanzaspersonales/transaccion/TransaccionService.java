package com.ahumada.finanzaspersonales.transaccion;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.ahumada.finanzaspersonales.common.exception.ResourceNotFoundException;

@Service
public class TransaccionService {

    @Autowired
    private TransaccionRepository repo;

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

    public Transaccion update(Transaccion transaccion) {
        return repo.save(transaccion);
    }

    public void deleteById(Long id) {
        Transaccion transaccion = this.getById(id);
        repo.delete(transaccion);
    }
}
