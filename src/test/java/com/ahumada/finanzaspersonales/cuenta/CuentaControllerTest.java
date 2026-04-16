package com.ahumada.finanzaspersonales.cuenta;

import static org.mockito.ArgumentMatchers.any;
import static org.mockito.Mockito.times;
import static org.mockito.Mockito.verify;
import static org.mockito.Mockito.when;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.jsonPath;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

import java.util.Collections;

import org.junit.jupiter.api.Test;

import static org.assertj.core.api.Assertions.assertThat;
import org.mockito.ArgumentCaptor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.WebMvcTest;
import org.springframework.test.context.bean.override.mockito.MockitoBean;
import org.springframework.test.web.servlet.MockMvc;

import com.ahumada.finanzaspersonales.usuario.Usuario;

@WebMvcTest(CuentaController.class)
class CuentaControllerTest {

	@Autowired
	private MockMvc mockMvc;

	@MockitoBean
	private CuentaService cuentaService;

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
