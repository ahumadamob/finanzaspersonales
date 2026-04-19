package com.ahumada.finanzaspersonales.cuenta;

import java.util.List;
import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;

import com.ahumada.finanzaspersonales.usuario.Usuario;

public interface CuentaRepository extends JpaRepository<Cuenta, Long>{
    List<Cuenta> findAllByRetiradoFalseOrderByNombreAsc();
    List<Cuenta> findAllByRetiradoFalseAndUsuarioOrderByNombreAsc(Usuario usuario);
    Optional<Cuenta> findByIdAndRetiradoFalse(Long id);
}
