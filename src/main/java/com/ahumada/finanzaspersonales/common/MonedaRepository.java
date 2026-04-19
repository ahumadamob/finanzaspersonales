package com.ahumada.finanzaspersonales.common;

import java.util.List;
import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;

public interface MonedaRepository extends JpaRepository<Moneda, Long> {
    List<Moneda> findAllByOrderByNombreAsc();
    Optional<Moneda> findById(Long id);
}
