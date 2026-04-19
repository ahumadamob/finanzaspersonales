package com.ahumada.finanzaspersonales.cuenta;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.ahumada.finanzaspersonales.common.exception.ResourceNotFoundException;
import com.ahumada.finanzaspersonales.usuario.Usuario;
import com.ahumada.finanzaspersonales.usuario.UsuarioService;

@Service
public class CuentaService {

    @Autowired
    private CuentaRepository repo;

    @Autowired
    private UsuarioService usuarioService;

    public List<Cuenta> getAll() {
        return repo.findAllByRetiradoFalseOrderByNombreAsc();
    }

    public List<Cuenta> getAllByUsuario(Usuario usuario) {
        return repo.findAllByRetiradoFalseAndUsuarioOrderByNombreAsc(usuario);
    }

    public Cuenta getById(Long id) {
        return repo.findByIdAndRetiradoFalse(id)
                .orElseThrow(() -> new ResourceNotFoundException(
                        "Cuenta con id: " + id + " no encontrado o retirado."));
    }

    public Cuenta save(Cuenta cuenta) {
        return repo.save(cuenta);
    }

    public Cuenta save(CuentaRequestDto dto) {
        CuentaMapper mapper = new CuentaMapper();
        Usuario usuario = usuarioService.getById(dto.getUsuarioId());
        Cuenta entity = mapper.toEntity(dto, usuario);
        return repo.save(entity);
    }

    public Cuenta update(Cuenta cuenta) {
        return repo.save(cuenta);

    }

    public Cuenta update(Long id, CuentaRequestDto dto) {
        Cuenta cuenta = this.getById(id);
        cuenta.setNombre(dto.getNombre());
        cuenta.setUsuario(usuarioService.getById(dto.getUsuarioId()));
        return repo.save(cuenta);
    }

    public void deleteById(Long id) {
        Cuenta cuenta = this.getById(id);
        cuenta.setRetirado(true);
        this.update(cuenta);
    }

}
