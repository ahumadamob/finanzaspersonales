package com.ahumada.finanzaspersonales.usuario;

import java.util.List;
import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;

public interface UsuarioRepository extends JpaRepository<Usuario, Long>{
    List<Usuario> findAllByRetiradoFalseOrderByIdAsc();
    Optional<Usuario> findByIdAndRetiradoFalse(Long id);
}
