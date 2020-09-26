package com.example.proyectojunit.simpleassert;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.CsvSource;
import org.junit.jupiter.params.provider.ValueSource;
import org.mockito.InjectMocks;
import org.mockito.MockitoAnnotations;

import java.time.Duration;
import java.util.Arrays;

import static org.junit.jupiter.api.Assertions.assertTimeout;

public class BazingaTestJUnit5 {

    @InjectMocks
    private Bazinga bazinga;

    @BeforeEach
    public void init() {
        MockitoAnnotations.initMocks(this);
    }

    @Test
    @DisplayName("El test de sheldon")
    public void dueloSheldonGanaTest() {
        String sheldon = "lagarto";
        String raj = "Spock";

        String respuesta = bazinga.duelo(sheldon, raj);

        Assertions.assertEquals(respuesta, "Sheldon");
    }

    @ParameterizedTest
    @ValueSource(strings = {"Spock", "piedra"})
    public void dueloRajGanaTest(String sheldon) {
        String raj = "papel";

        String respuesta = bazinga.duelo(sheldon, raj);

        Assertions.assertEquals(respuesta, "Raj");
    }

    @ParameterizedTest
    @CsvSource({"lagarto,piedra", "papel,tijeras", "papel,lagarto"})
    public void deuloSiempreGanaSheldon(String sheldon, String raj) {
        String respuesta = bazinga.duelo(sheldon, raj);

        Assertions.assertEquals(respuesta, "Raj");
    }

    @Test
    public void dueloEmpateTest() {
        String sheldon = "Spock";
        String raj = "Spock";

        String respuesta = bazinga.duelo(sheldon, raj);

        Assertions.assertEquals(respuesta, "Jugar de nuevo");
    }

    @Test
    public void regalasValidarTest() {
        String objetoEvaluar = "lagarto";
        String objetoVencido = "papel";

        boolean condicion = bazinga.reglas.get(objetoEvaluar).contains(objetoVencido);

        Assertions.assertTrue(condicion);
    }

    @Test
    public void testPerformance() {
        assertTimeout(Duration.ofMillis(100), () -> {
            int[] array = {34, 5, 1, 36};
            for (int i = 0; i < 1000000; i++) {
                array[0] = i;
                Arrays.sort(array);
            }
        });
    }

}
