package com.ahumada.finanzaspersonales.cuenta;

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
import java.util.Collections;
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

import com.ahumada.finanzaspersonales.usuario.Usuario;
import com.ahumada.finanzaspersonales.usuario.UsuarioService;

@ExtendWith(MockitoExtension.class)
class CuentaControllerTest {

    @Mock
    private CuentaService cuentaService;

    @Mock
    private UsuarioService usuarioService;

    @InjectMocks
    private CuentaController cuentaController;

    private MockMvc mockMvc;

    @BeforeEach
    void setUp() {
        mockMvc = MockMvcBuilders.standaloneSetup(cuentaController).build();
    }

    @Test
    void getAllByUsuario_debeResponderConPayloadHomogeneo() throws Exception {
        when(usuarioService.getById(99L)).thenReturn(new Usuario(99L));
        when(cuentaService.getAllByUsuario(any(Usuario.class))).thenReturn(Collections.emptyList());

        mockMvc.perform(get("/v1/cuenta/usuario/{usuarioId}", 99L))
                .andExpect(status().isOk())
                .andExpect(jsonPath("$.success").value(true))
                .andExpect(jsonPath("$.message").value("Cuentas obtenidas correctamente"))
                .andExpect(jsonPath("$.data").isArray());
    }

    @Test
    void getAll_debeRetornar200YContratoJson() throws Exception {
        Cuenta cuenta = cuenta(10L, "Caja ahorro", 2L);
        when(cuentaService.getAll()).thenReturn(List.of(cuenta));

        mockMvc.perform(get("/v1/cuenta"))
                .andExpect(status().isOk())
                .andExpect(jsonPath("$.success").value(true))
                .andExpect(jsonPath("$.message").value("Cuentas obtenidas correctamente"))
                .andExpect(jsonPath("$.data[0].id").value(10L))
                .andExpect(jsonPath("$.data[0].nombre").value("Caja ahorro"));
    }

    @Test
    void getById_debeRetornar200YContratoJson() throws Exception {
        when(cuentaService.getById(10L)).thenReturn(cuenta(10L, "Caja ahorro", 2L));

        mockMvc.perform(get("/v1/cuenta/{id}", 10L))
                .andExpect(status().isOk())
                .andExpect(jsonPath("$.success").value(true))
                .andExpect(jsonPath("$.message").value("Cuenta obtenida correctamente"))
                .andExpect(jsonPath("$.data.id").value(10L));
    }

    @Test
    void post_debeRetornar200YContratoJson() throws Exception {
        when(cuentaService.save(any(CuentaRequestDto.class))).thenReturn(cuenta(11L, "Billetera", 2L));

        mockMvc.perform(post("/v1/cuenta")
                .contentType(MediaType.APPLICATION_JSON)
                .content("{\"nombre\":\"Billetera\",\"usuarioId\":2}"))
                .andExpect(status().isOk())
                .andExpect(jsonPath("$.success").value(true))
                .andExpect(jsonPath("$.message").value("Cuenta creada correctamente"))
                .andExpect(jsonPath("$.data.id").value(11L));
    }

    @Test
    void put_debeUsarIdDelPathYNoDelBody() throws Exception {
        when(cuentaService.update(any(Long.class), any(CuentaRequestDto.class))).thenReturn(cuenta(55L, "Nueva", 2L));

        mockMvc.perform(put("/v1/cuenta/{id}", 55L)
                .contentType(MediaType.APPLICATION_JSON)
                .content("{\"id\":999,\"nombre\":\"Nueva\",\"usuarioId\":2}"))
                .andExpect(status().isOk())
                .andExpect(jsonPath("$.success").value(true))
                .andExpect(jsonPath("$.message").value("Cuenta actualizada correctamente"))
                .andExpect(jsonPath("$.data.id").value(55L));

        ArgumentCaptor<Long> captor = ArgumentCaptor.forClass(Long.class);
        verify(cuentaService).update(captor.capture(), any(CuentaRequestDto.class));
        org.junit.jupiter.api.Assertions.assertEquals(55L, captor.getValue());
    }

    @Test
    void delete_debeRetornar200YContratoJson() throws Exception {
        doNothing().when(cuentaService).deleteById(44L);

        mockMvc.perform(delete("/v1/cuenta/{id}", 44L))
                .andExpect(status().isOk())
                .andExpect(jsonPath("$.success").value(true))
                .andExpect(jsonPath("$.message").value("Cuenta eliminada correctamente"))
                .andExpect(jsonPath("$.data").isEmpty());
    }

    private Cuenta cuenta(Long id, String nombre, Long usuarioId) {
        Cuenta cuenta = new Cuenta();
        cuenta.setId(id);
        cuenta.setNombre(nombre);
        Usuario usuario = new Usuario();
        usuario.setId(usuarioId);
        usuario.setNombre("Usuario");
        usuario.setFechaCreacion(LocalDateTime.now());
        usuario.setFechaModificacion(LocalDateTime.now());
        cuenta.setUsuario(usuario);
        cuenta.setFechaCreacion(LocalDateTime.now());
        cuenta.setFechaModificacion(LocalDateTime.now());
        return cuenta;
    }
}
