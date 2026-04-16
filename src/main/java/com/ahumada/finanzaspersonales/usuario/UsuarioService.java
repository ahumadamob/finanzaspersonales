package com.ahumada.finanzaspersonales.usuario;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.ahumada.finanzaspersonales.common.exception.ResourceNotFoundException;

@Service
public class UsuarioService {
	
	@Autowired
	private UsuarioRepository repo;

	public List<Usuario>getAll(){
		return repo.findAllByRetiradoFalseOrderByNombreAsc();
	}
	
	public Usuario save(Usuario usuario) {
		return repo.save(usuario);
	}

	public Usuario getById(Long id) {
		return repo.findByIdAndRetiradoFalse(id)
				.orElseThrow(() -> new ResourceNotFoundException(
						"Usuario con id: " + id + " no encontrado o retirado."));
	}
	
	public long count() {
		return repo.count();
	}
	
	
}
