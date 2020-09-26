package com.example.proyectojunit.parqueadero.controlador;

import com.example.proyectojunit.parqueadero.infraestructura.controlador.ControladorRegistro;
import org.hamcrest.Matchers;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.http.MediaType;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.request.MockMvcRequestBuilders;
import org.springframework.test.web.servlet.result.MockMvcResultMatchers;
import org.springframework.test.web.servlet.setup.MockMvcBuilders;

@SpringBootTest
public class ControladorRegistroTest {

    private MockMvc mockMvc;
    private final String json = "{\"vehiculo\":{\"tipo\":\"MOTO\",\"placa\":\"ABC2\",\"cilindraje\":2000},\"fechaEntrada\":\"2019-06-25T03:00:00.000+0000\"}";

    @Autowired
    private ControladorRegistro controladorRegistro;

    @BeforeEach
    public void setUp() throws Exception {
        mockMvc = MockMvcBuilders.standaloneSetup(controladorRegistro).build();
    }

    @Test
    public void testGetRegistros() throws Exception {
        mockMvc.perform(MockMvcRequestBuilders.get("/registro/listar"))
                .andExpect(MockMvcResultMatchers.status().isOk());
    }

    @Test
    public void testCrearRegistro() throws Exception {
        mockMvc.perform(MockMvcRequestBuilders.post("/registro/crear")
                .content(this.json)
                .contentType(MediaType.APPLICATION_JSON))
                .andExpect(MockMvcResultMatchers.status().isOk())
                .andExpect(MockMvcResultMatchers.jsonPath("$.costoEstadia", Matchers.is(0.0)));
    }

    @Test
    public void testActulizarRegistro() throws Exception {
        testCrearRegistro();

        mockMvc.perform(MockMvcRequestBuilders.put("/registro/actualizar")
                .content(this.json)
                .contentType(MediaType.APPLICATION_JSON))
                .andExpect(MockMvcResultMatchers.status().isOk())
                .andExpect(MockMvcResultMatchers.jsonPath("$.costoEstadia", Matchers.is(1778000.0)));
    }

    @Test
    public void testActualizarRegistroFallo() throws Exception {
        String jsonDiferente = "{\"vehiculo\":{\"tipo\":\"MOTO\",\"placa\":\"ABC3\",\"cilindraje\":2000},\"fechaEntrada\":\"2019-06-25T03:00:00.000+0000\"}";

        Assertions.assertThrows(Exception.class, () -> {
            mockMvc.perform(MockMvcRequestBuilders.put("/registro/actualizar")
                    .contentType(MediaType.APPLICATION_JSON)
                    .content(jsonDiferente))
                    .andExpect(MockMvcResultMatchers.status().isOk());
        });
    }
}
