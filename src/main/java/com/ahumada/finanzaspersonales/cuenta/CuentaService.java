package com.ahumada.finanzaspersonales.cuenta;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.ahumada.finanzaspersonales.usuario.Usuario;
import com.ahumada.finanzaspersonales.common.exception.ResourceNotFoundException;

@Service
public class CuentaService {
	
	@Autowired
	private CuentaRepository repo;
	
	public List<Cuenta> getAll(Usuario usuario){
		return repo.findAllByRetiradoFalseAndUsuarioOrderByNombreAsc(usuario);
	}
	
	public Cuenta getById(Long id) {
		return repo	.findByIdAndRetiradoFalse(id)
	            	.orElseThrow(() -> new ResourceNotFoundException(
	                "Cuenta con id: " + id + " no encontrada o retirada."));
	}
	
	public Cuenta update(Cuenta cuenta) {
		return repo.save(cuenta);
		
	}
	
	public void deleteById(Long id) {
		Cuenta cuenta = this.getById(id);
		cuenta.setRetirado(true);
		this.update(cuenta);		
	}

}
