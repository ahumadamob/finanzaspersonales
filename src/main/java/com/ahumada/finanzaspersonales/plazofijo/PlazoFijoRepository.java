package com.ahumada.finanzaspersonales.plazofijo;

import java.util.List;
import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

public interface PlazoFijoRepository extends JpaRepository<PlazoFijo, Long> {
    List<PlazoFijo> findAllByOrderByFechaVencimientoAsc();

    @Query("SELECT p FROM PlazoFijo p WHERE p.id = :id")
    Optional<PlazoFijo> findByIdPlazoFijo(@Param("id") Long id);
}
