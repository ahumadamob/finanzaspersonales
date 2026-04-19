package com.ahumada.finanzaspersonales.common;

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
class MonedaServiceTest {

    @Mock
    private MonedaRepository repo;

    @InjectMocks
    private MonedaService service;

    @Test
    void getById_ok() {
        Moneda moneda = new Moneda();
        when(repo.findById(10L)).thenReturn(Optional.of(moneda));

        service.getById(10L);

        verify(repo).findById(10L);
    }

    @Test
    void getById_resourceNotFound() {
        when(repo.findById(404L)).thenReturn(Optional.empty());

        assertThrows(ResourceNotFoundException.class, () -> service.getById(404L));
    }

    @Test
    void delete_hardDelete() {
        Moneda moneda = new Moneda();
        when(repo.findById(12L)).thenReturn(Optional.of(moneda));

        service.deleteById(12L);

        verify(repo).delete(moneda);
    }
}
