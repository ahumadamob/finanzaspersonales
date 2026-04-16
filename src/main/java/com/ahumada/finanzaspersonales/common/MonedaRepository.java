package com.ahumada.finanzaspersonales.common;

import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;

public interface MonedaRepository extends JpaRepository<Moneda, Long> {
    Optional<Moneda> findById(Long id);
}
