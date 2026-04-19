package com.ahumada.finanzaspersonales.usuario;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.ahumada.finanzaspersonales.common.exception.ResourceNotFoundException;

@Service
public class UsuarioService {

    @Autowired
    private UsuarioRepository repo;

    public List<Usuario> getAll() {
        return repo.findAllByRetiradoFalseOrderByNombreAsc();
    }

    public Usuario save(Usuario usuario) {
        return repo.save(usuario);
    }

    public Usuario save(UsuarioRequestDto dto) {
        UsuarioMapper mapper = new UsuarioMapper();
        Usuario entity = mapper.toEntity(dto);
        return repo.save(entity);
    }

    public Usuario getById(Long id) {
        return repo.findByIdAndRetiradoFalse(id)
                .orElseThrow(() -> new ResourceNotFoundException(
                        "Usuario con id: " + id + " no encontrado o retirado."));
    }

    public Usuario update(Usuario usuario) {
        return repo.save(usuario);
    }

    public Usuario update(Long id, UsuarioRequestDto dto) {
        Usuario usuario = this.getById(id);
        usuario.setNombre(dto.getNombre());
        return repo.save(usuario);
    }

    public void deleteById(Long id) {
        Usuario usuario = this.getById(id);
        usuario.setRetirado(true);
        this.update(usuario);
    }

    public long count() {
        return repo.count();
    }

}
