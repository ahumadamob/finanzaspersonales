package com.ahumada.finanzaspersonales.cuenta;

import static org.assertj.core.api.Assertions.assertThat;
import static org.mockito.ArgumentMatchers.any;
import static org.mockito.Mockito.times;
import static org.mockito.Mockito.verify;
import static org.mockito.Mockito.when;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.jsonPath;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

import java.util.Collections;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.ArgumentCaptor;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.setup.MockMvcBuilders;

import com.ahumada.finanzaspersonales.usuario.Usuario;

@ExtendWith(MockitoExtension.class)
class CuentaControllerTest {

	@Mock
	private CuentaService cuentaService;

	@InjectMocks
	private CuentaController cuentaController;

	private MockMvc mockMvc;

	@BeforeEach
	void setUp() {
		mockMvc = MockMvcBuilders.standaloneSetup(cuentaController).build();
	}

	@Test
	void getAll_debeMapearPathVariableUsuarioIdCorrectamente() throws Exception {
		when(cuentaService.getAll(any(Usuario.class))).thenReturn(Collections.emptyList());

		mockMvc.perform(get("/v1/cuenta/{usuario_id}", 99L))
				.andExpect(status().isOk())
				.andExpect(jsonPath("$.success").value(true))
				.andExpect(jsonPath("$.message").value("Cuentas obtenidas correctamente"))
				.andExpect(jsonPath("$.data").isArray());

		ArgumentCaptor<Usuario> usuarioCaptor = ArgumentCaptor.forClass(Usuario.class);
		verify(cuentaService, times(1)).getAll(usuarioCaptor.capture());
		assertThat(usuarioCaptor.getValue().getId()).isEqualTo(99L);
	}
}
