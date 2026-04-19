package com.ahumada.finanzaspersonales.usuario;

import static org.mockito.ArgumentMatchers.any;
import static org.mockito.Mockito.doNothing;
import static org.mockito.Mockito.verify;
import static org.mockito.Mockito.when;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.delete;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.post;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.put;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.jsonPath;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

import java.time.LocalDateTime;
import java.util.List;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.ArgumentCaptor;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;
import org.springframework.http.MediaType;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.setup.MockMvcBuilders;

@ExtendWith(MockitoExtension.class)
class UsuarioControllerTest {

    @Mock
    private UsuarioService usuarioService;

    @InjectMocks
    private UsuarioController controller;

    private MockMvc mockMvc;

    @BeforeEach
    void setUp() {
        mockMvc = MockMvcBuilders.standaloneSetup(controller).build();
    }

    @Test
    void crudContract() throws Exception {
        Usuario usuario = usuario(7L, "Ana");
        when(usuarioService.getAll()).thenReturn(List.of(usuario));
        when(usuarioService.getById(7L)).thenReturn(usuario);
        when(usuarioService.save(any(UsuarioRequestDto.class))).thenReturn(usuario(8L, "Neo"));
        when(usuarioService.update(any(Long.class), any(UsuarioRequestDto.class))).thenReturn(usuario);
        doNothing().when(usuarioService).deleteById(7L);

        mockMvc.perform(get("/v1/usuario"))
                .andExpect(status().isOk())
                .andExpect(jsonPath("$.data[0].id").value(7L));

        mockMvc.perform(get("/v1/usuario/{id}", 7L))
                .andExpect(status().isOk())
                .andExpect(jsonPath("$.message").value("Usuario obtenido correctamente"));

        mockMvc.perform(post("/v1/usuario").contentType(MediaType.APPLICATION_JSON)
                .content("{\"nombre\":\"Neo\"}"))
                .andExpect(status().isOk())
                .andExpect(jsonPath("$.data.id").value(8L));

        mockMvc.perform(put("/v1/usuario/{id}", 7L).contentType(MediaType.APPLICATION_JSON)
                .content("{\"id\":999,\"nombre\":\"Ana\"}"))
                .andExpect(status().isOk())
                .andExpect(jsonPath("$.data.id").value(7L));

        ArgumentCaptor<Long> captor = ArgumentCaptor.forClass(Long.class);
        verify(usuarioService).update(captor.capture(), any(UsuarioRequestDto.class));
        org.junit.jupiter.api.Assertions.assertEquals(7L, captor.getValue());

        mockMvc.perform(delete("/v1/usuario/{id}", 7L))
                .andExpect(status().isOk())
                .andExpect(jsonPath("$.success").value(true));
    }

    private Usuario usuario(Long id, String nombre) {
        Usuario usuario = new Usuario();
        usuario.setId(id);
        usuario.setNombre(nombre);
        usuario.setFechaCreacion(LocalDateTime.now());
        usuario.setFechaModificacion(LocalDateTime.now());
        return usuario;
    }
}
