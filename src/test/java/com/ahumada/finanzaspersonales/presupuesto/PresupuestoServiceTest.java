package com.ahumada.finanzaspersonales.presupuesto;

import static org.junit.jupiter.api.Assertions.assertThrows;
import static org.mockito.Mockito.verify;
import static org.mockito.Mockito.when;

import java.util.Optional;

import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;

import com.ahumada.finanzaspersonales.common.exception.ResourceNotFoundException;

@ExtendWith(MockitoExtension.class)
class PresupuestoServiceTest {

    @Mock
    private PresupuestoRepository repo;

    @InjectMocks
    private PresupuestoService service;

    @Test
    void getById_ok() {
        Presupuesto entity = new Presupuesto();
        when(repo.findByIdPresupuesto(1L)).thenReturn(Optional.of(entity));

        service.getById(1L);

        verify(repo).findByIdPresupuesto(1L);
    }

    @Test
    void getById_resourceNotFound() {
        when(repo.findByIdPresupuesto(999L)).thenReturn(Optional.empty());

        assertThrows(ResourceNotFoundException.class, () -> service.getById(999L));
    }

    @Test
    void delete_hardDelete() {
        Presupuesto entity = new Presupuesto();
        when(repo.findByIdPresupuesto(2L)).thenReturn(Optional.of(entity));

        service.deleteById(2L);

        verify(repo).delete(entity);
    }
}
