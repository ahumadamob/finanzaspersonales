package com.ahumada.finanzaspersonales.presupuesto;

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
import java.time.YearMonth;
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
class PresupuestoControllerTest {

    @Mock
    private PresupuestoService presupuestoService;

    @InjectMocks
    private PresupuestoController controller;

    private MockMvc mockMvc;

    @BeforeEach
    void setUp() {
        mockMvc = MockMvcBuilders.standaloneSetup(controller).build();
    }

    @Test
    void crudContract() throws Exception {
        Presupuesto presupuesto = presupuesto(6L, YearMonth.of(2026, 4));
        when(presupuestoService.getAll()).thenReturn(List.of(presupuesto));
        when(presupuestoService.getById(6L)).thenReturn(presupuesto);
        when(presupuestoService.save(any(PresupuestoRequestDto.class))).thenReturn(presupuesto(7L, YearMonth.of(2026, 5)));
        when(presupuestoService.update(any(Long.class), any(PresupuestoRequestDto.class))).thenReturn(presupuesto);
        doNothing().when(presupuestoService).deleteById(6L);

        mockMvc.perform(get("/v1/presupuesto")).andExpect(status().isOk()).andExpect(jsonPath("$.data[0].id").value(6L));
        mockMvc.perform(get("/v1/presupuesto/{id}", 6L)).andExpect(status().isOk())
                .andExpect(jsonPath("$.message").value("Presupuesto obtenido correctamente"));
        mockMvc.perform(post("/v1/presupuesto").contentType(MediaType.APPLICATION_JSON)
                .content("{\"periodo\":\"2026-05\",\"estado\":\"VIGENTE\"}"))
                .andExpect(status().isOk()).andExpect(jsonPath("$.data.id").value(7L));
        mockMvc.perform(put("/v1/presupuesto/{id}", 6L).contentType(MediaType.APPLICATION_JSON)
                .content("{\"id\":999,\"periodo\":\"2026-04\",\"estado\":\"BORRADOR\"}"))
                .andExpect(status().isOk()).andExpect(jsonPath("$.data.id").value(6L));

        ArgumentCaptor<Long> captor = ArgumentCaptor.forClass(Long.class);
        verify(presupuestoService).update(captor.capture(), any(PresupuestoRequestDto.class));
        org.junit.jupiter.api.Assertions.assertEquals(6L, captor.getValue());

        mockMvc.perform(delete("/v1/presupuesto/{id}", 6L)).andExpect(status().isOk())
                .andExpect(jsonPath("$.success").value(true));
    }

    private Presupuesto presupuesto(Long id, YearMonth periodo) {
        Presupuesto p = new Presupuesto();
        p.setId(id);
        p.setPeriodo(periodo);
        p.setEstado(EstadoPresupuesto.BORRADOR);
        p.setFechaCreacion(LocalDateTime.now());
        p.setFechaModificacion(LocalDateTime.now());
        return p;
    }
}
