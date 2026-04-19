package com.ahumada.finanzaspersonales.common;

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
class MonedaControllerTest {

    @Mock
    private MonedaService monedaService;

    @InjectMocks
    private MonedaController controller;

    private MockMvc mockMvc;

    @BeforeEach
    void setUp() {
        mockMvc = MockMvcBuilders.standaloneSetup(controller).build();
    }

    @Test
    void crudContract() throws Exception {
        Moneda ars = moneda(1L, "ARS");
        when(monedaService.getAll()).thenReturn(List.of(ars));
        when(monedaService.getById(1L)).thenReturn(ars);
        when(monedaService.save(any(MonedaRequestDto.class))).thenReturn(moneda(2L, "USD"));
        when(monedaService.update(any(Long.class), any(MonedaRequestDto.class))).thenReturn(ars);
        doNothing().when(monedaService).deleteById(1L);

        mockMvc.perform(get("/v1/moneda")).andExpect(status().isOk()).andExpect(jsonPath("$.data[0].id").value(1L));
        mockMvc.perform(get("/v1/moneda/{id}", 1L)).andExpect(status().isOk())
                .andExpect(jsonPath("$.message").value("Moneda obtenida correctamente"));
        mockMvc.perform(post("/v1/moneda").contentType(MediaType.APPLICATION_JSON).content("{\"nombre\":\"USD\"}"))
                .andExpect(status().isOk()).andExpect(jsonPath("$.data.id").value(2L));
        mockMvc.perform(put("/v1/moneda/{id}", 1L).contentType(MediaType.APPLICATION_JSON)
                .content("{\"id\":999,\"nombre\":\"ARS\"}"))
                .andExpect(status().isOk()).andExpect(jsonPath("$.data.id").value(1L));

        ArgumentCaptor<Long> captor = ArgumentCaptor.forClass(Long.class);
        verify(monedaService).update(captor.capture(), any(MonedaRequestDto.class));
        org.junit.jupiter.api.Assertions.assertEquals(1L, captor.getValue());

        mockMvc.perform(delete("/v1/moneda/{id}", 1L)).andExpect(status().isOk())
                .andExpect(jsonPath("$.success").value(true));
    }

    private Moneda moneda(Long id, String nombre) {
        Moneda moneda = new Moneda();
        moneda.setId(id);
        moneda.setNombre(nombre);
        moneda.setFechaCreacion(LocalDateTime.now());
        moneda.setFechaModificacion(LocalDateTime.now());
        return moneda;
    }
}
