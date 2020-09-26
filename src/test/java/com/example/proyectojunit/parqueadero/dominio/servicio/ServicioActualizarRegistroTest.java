package com.example.proyectojunit.parqueadero.dominio.servicio;

import com.example.proyectojunit.parqueadero.dominio.excepcion.ParqueaderoExcepcion;
import com.example.proyectojunit.parqueadero.dominio.repositorio.RepositorioRegistro;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.MockitoAnnotations;

import static org.mockito.Mockito.when;

public class ServicioActualizarRegistroTest {

    @InjectMocks
    private ServicioActualizarRegistro servicioActualizarRegistro;

    @Mock
    private ServicioParqueadero servicioParqueadero;

    @Mock
    private RepositorioRegistro repositorioRegistro;

    @BeforeEach
    public void init() {
        MockitoAnnotations.initMocks(this);
    }

    /*
    @Test (expected = ParqueaderoExcepcion.class)
    public void validarExistenciaEnParqueadero() throws ParqueaderoExcepcion {
        when(servicioParqueadero.existeEnParqueadero("CARRO")).thenReturn(false);

        this.servicioActualizarRegistro.validarExistenciaEnParqueadero("CARRO");
    }*/

    @Test
    public void validarExistenciaEnParqueadero2() {
        when(servicioParqueadero.existeEnParqueadero("CARRO")).thenReturn(false);

        Assertions.assertThrows(ParqueaderoExcepcion.class, () -> {
            this.servicioActualizarRegistro.validarExistenciaEnParqueadero("CARRO");
        });
    }

}
