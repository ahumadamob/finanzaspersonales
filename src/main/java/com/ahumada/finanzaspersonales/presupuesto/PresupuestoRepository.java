package com.ahumada.finanzaspersonales.presupuesto;

import java.util.List;
import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

public interface PresupuestoRepository extends JpaRepository<Presupuesto, Long> {
    List<Presupuesto> findAllByOrderByPeriodoAsc();

    @Query("SELECT p FROM Presupuesto p WHERE p.id = :id")
    Optional<Presupuesto> findByIdPresupuesto(@Param("id") Long id);
}
