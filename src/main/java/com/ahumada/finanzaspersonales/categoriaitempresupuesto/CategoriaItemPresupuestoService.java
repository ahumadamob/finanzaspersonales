package com.ahumada.finanzaspersonales.categoriaitempresupuesto;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.ahumada.finanzaspersonales.common.exception.ResourceNotFoundException;
import com.ahumada.finanzaspersonales.usuario.Usuario;
import com.ahumada.finanzaspersonales.usuario.UsuarioService;

@Service
public class CategoriaItemPresupuestoService {

    @Autowired
    private CategoriaItemPresupuestoRepository repo;

    @Autowired
    private UsuarioService usuarioService;

    public List<CategoriaItemPresupuesto> getAll() {
        return repo.findAllByRetiradoFalseOrderByNombreAsc();
    }

    public List<CategoriaItemPresupuesto> getAllByUsuario(Usuario usuario) {
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

    public CategoriaItemPresupuesto save(CategoriaItemPresupuestoRequestDto dto) {
        CategoriaItemPresupuestoMapper mapper = new CategoriaItemPresupuestoMapper();
        Usuario usuario = usuarioService.getById(dto.getUsuarioId());
        CategoriaItemPresupuesto entity = mapper.toEntity(dto, usuario);
        return repo.save(entity);
    }

    public CategoriaItemPresupuesto update(CategoriaItemPresupuesto categoria) {
        return repo.save(categoria);
    }

    public CategoriaItemPresupuesto update(Long id, CategoriaItemPresupuestoRequestDto dto) {
        CategoriaItemPresupuesto categoria = this.getById(id);
        categoria.setNombre(dto.getNombre());
        categoria.setTipo(dto.getTipo());
        categoria.setUsuario(usuarioService.getById(dto.getUsuarioId()));
        return repo.save(categoria);
    }

    public void deleteById(Long id) {
        CategoriaItemPresupuesto categoria = this.getById(id);
        categoria.setRetirado(true);
        this.update(categoria);
    }
}
