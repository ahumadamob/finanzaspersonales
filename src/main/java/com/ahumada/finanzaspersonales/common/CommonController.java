package com.ahumada.finanzaspersonales.common;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.ahumada.finanzaspersonales.usuario.Usuario;
import com.ahumada.finanzaspersonales.usuario.UsuarioService;

@RestController
@RequestMapping("/v1/common")
public class CommonController {
	
	@Autowired
	private UsuarioService usuarioService;
	
    @GetMapping("/init")
    public List<String> initDB() {
    	List<String> console = new ArrayList<String>();
    	console.add("Verificando cantidad de usuarios...");
    	long usuariosCount = usuarioService.count(); 
    	console.add("Cantidad de usuarios encontrados: " + usuariosCount); 
    	
    	if(usuariosCount == 0) {
    		Usuario usuario = new Usuario();
    		usuario.setNombre("Default");
    		usuarioService.save(usuario);
    		console.add("Se ha añadido el usuario Default");
    	}
    	
    	return console;
    	
        
    }	

}
