package com.ahumada.finanzaspersonales.cuenta;

import static org.mockito.ArgumentMatchers.any;
import static org.mockito.Mockito.when;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.jsonPath;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

import java.util.Collections;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;
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
}
