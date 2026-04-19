package com.ahumada.finanzaspersonales.usuario;

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
class UsuarioServiceTest {

    @Mock
    private UsuarioRepository repo;

    @InjectMocks
    private UsuarioService service;

    @Test
    void getById_ok() {
        Usuario usuario = new Usuario();
        when(repo.findByIdAndRetiradoFalse(4L)).thenReturn(Optional.of(usuario));

        service.getById(4L);

        verify(repo).findByIdAndRetiradoFalse(4L);
    }

    @Test
    void getById_resourceNotFound() {
        when(repo.findByIdAndRetiradoFalse(404L)).thenReturn(Optional.empty());

        assertThrows(ResourceNotFoundException.class, () -> service.getById(404L));
    }

    @Test
    void delete_softDelete() {
        Usuario usuario = new Usuario();
        usuario.setRetirado(false);
        when(repo.findByIdAndRetiradoFalse(5L)).thenReturn(Optional.of(usuario));
        when(repo.save(usuario)).thenReturn(usuario);

        service.deleteById(5L);

        org.junit.jupiter.api.Assertions.assertTrue(usuario.isRetirado());
        verify(repo, never()).delete(usuario);
        verify(repo).save(usuario);
    }
}
