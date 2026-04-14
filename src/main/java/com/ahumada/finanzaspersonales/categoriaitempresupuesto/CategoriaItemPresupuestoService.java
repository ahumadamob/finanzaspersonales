package com.ahumada.finanzaspersonales.categoriaitempresupuesto;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.ahumada.finanzaspersonales.common.exception.ResourceNotFoundException;
import com.ahumada.finanzaspersonales.usuario.Usuario;

@Service
public class CategoriaItemPresupuestoService {

    @Autowired
    private CategoriaItemPresupuestoRepository repo;

    public List<CategoriaItemPresupuesto> getAll(Usuario usuario) {
        return repo.findAllByUsuarioAndRetiradoFalseOrderByNombreAsc(usuario);
    }

    public CategoriaItemPresupuesto getById(Long id) {
        return repo.findByIdAndRetiradoFalse(id)
                .orElseThrow(() -> new ResourceNotFoundException(
                        "CategoriaItemPresupuesto con id: " + id + " no encontrado o retirado."));
    }

    public CategoriaItemPresupuesto save(CategoriaItemPresupuesto categoria) {
        return repo.save(categoria);
    }

    public CategoriaItemPresupuesto update(CategoriaItemPresupuesto categoria) {
        return repo.save(categoria);
    }

    public void deleteById(Long id) {
        CategoriaItemPresupuesto categoria = this.getById(id);
        categoria.setRetirado(true);
        this.update(categoria);
    }
}
