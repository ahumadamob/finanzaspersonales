package com.ahumada.finanzaspersonales.common;

import java.util.List;
import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

public interface ImporteMonetarioRepository extends JpaRepository<ImporteMonetario, Long> {
    List<ImporteMonetario> findAllByOrderByMontoAsc();

    @Query("SELECT i FROM ImporteMonetario i WHERE i.id = :id")
    Optional<ImporteMonetario> findByIdImporteMonetario(@Param("id") Long id);
}
