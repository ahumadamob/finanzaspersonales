package com.ahumada.finanzaspersonales.transaccion;

import java.util.List;
import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

public interface TransaccionRepository extends JpaRepository<Transaccion, Long> {
    List<Transaccion> findAllByOrderByFechaTransaccionDesc();

    @Query("SELECT t FROM Transaccion t WHERE t.id = :id")
    Optional<Transaccion> findByIdTransaccion(@Param("id") Long id);
}
