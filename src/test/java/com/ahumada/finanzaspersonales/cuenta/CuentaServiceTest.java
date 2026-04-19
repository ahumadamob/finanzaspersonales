package com.ahumada.finanzaspersonales.cuenta;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertThrows;
import static org.mockito.Mockito.never;
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
class CuentaServiceTest {

    @Mock
    private CuentaRepository repo;

    @InjectMocks
    private CuentaService service;

    @Test
    void getById_ok() {
        Cuenta cuenta = new Cuenta();
        cuenta.setId(1L);
        when(repo.findByIdAndRetiradoFalse(1L)).thenReturn(Optional.of(cuenta));

        Cuenta actual = service.getById(1L);

        assertEquals(1L, actual.getId());
    }

    @Test
    void getById_resourceNotFound() {
        when(repo.findByIdAndRetiradoFalse(99L)).thenReturn(Optional.empty());

        assertThrows(ResourceNotFoundException.class, () -> service.getById(99L));
    }

    @Test
    void delete_softDelete() {
        Cuenta cuenta = new Cuenta();
        cuenta.setId(3L);
        cuenta.setRetirado(false);
        when(repo.findByIdAndRetiradoFalse(3L)).thenReturn(Optional.of(cuenta));
        when(repo.save(cuenta)).thenReturn(cuenta);

        service.deleteById(3L);

        assertEquals(true, cuenta.isRetirado());
        verify(repo, never()).delete(cuenta);
        verify(repo).save(cuenta);
    }
}
