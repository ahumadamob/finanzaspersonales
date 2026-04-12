package com.ahumada.finanzaspersonales.usuario;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class UsuarioService {
	
	@Autowired
	private UsuarioRepository repo;

	public List<Usuario>getAll(){
		return repo.findAllByRetiradoFalseOrderByIdAsc();
	}
	
	public Usuario save(Usuario usuario) {
		return repo.save(usuario);
	}
	
	public long count() {
		return repo.count();
	}
	
	
}
