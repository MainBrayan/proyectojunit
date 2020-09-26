package com.example.proyectojunit.parqueadero.dominio.servicio;

import com.example.proyectojunit.parqueadero.dominio.excepcion.ParqueaderoExcepcion;
import com.example.proyectojunit.parqueadero.dominio.modelo.Vehiculo;
import com.example.proyectojunit.parqueadero.dominio.repositorio.RepositorioRegistro;
import com.example.proyectojunit.parqueadero.dominio.testdatabuilder.VehiculoTestDataBuilder;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.MockitoAnnotations;

import java.util.Calendar;
import java.util.GregorianCalendar;

import static org.mockito.Mockito.when;

public class ServicioCrearRegistroTest {
    @InjectMocks
    private ServicioCrearRegistro servicioCrearRegistro;

    @Mock
    private ServicioParqueadero servicioParqueadero;

    @Mock
    private RepositorioRegistro repositorioRegistro;

    @BeforeEach
    public void init() {
        MockitoAnnotations.initMocks(this);
    }

    @Test
    public void validarAccesoPorPlacaMoto() {
        Vehiculo vehiculo = new VehiculoTestDataBuilder().conTipo("MOTO").conPlaca("A4-B6").conCilindraje(200).buil();
        Calendar diaActual = new GregorianCalendar(2019, 5, 24, 20, 00);

        when(servicioParqueadero.accesoPorPlacas(vehiculo, diaActual)).thenReturn(false);

        Assertions.assertThrows(ParqueaderoExcepcion.class, () -> {
            this.servicioCrearRegistro.validarAccesoPorPlacas(vehiculo, diaActual);
        });
    }

}
