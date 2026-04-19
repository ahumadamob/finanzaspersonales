package com.ahumada.finanzaspersonales.categoriaitempresupuesto;

import java.util.List;
import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;

import com.ahumada.finanzaspersonales.usuario.Usuario;

public interface CategoriaItemPresupuestoRepository extends JpaRepository<CategoriaItemPresupuesto, Long> {
    List<CategoriaItemPresupuesto> findAllByRetiradoFalseOrderByNombreAsc();

    List<CategoriaItemPresupuesto> findAllByUsuarioAndRetiradoFalseOrderByNombreAsc(Usuario usuario);

    Optional<CategoriaItemPresupuesto> findByIdAndRetiradoFalse(Long id);
}
