package com.ahumada.finanzaspersonales.itempresupuesto;

import java.util.List;
import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

public interface ItemPresupuestoRepository extends JpaRepository<ItemPresupuesto, Long> {
    List<ItemPresupuesto> findAllByOrderByFechaVencimientoAscIdAsc();

    @Query("SELECT i FROM ItemPresupuesto i WHERE i.id = :id")
    Optional<ItemPresupuesto> findByIdItemPresupuesto(@Param("id") Long id);
}
