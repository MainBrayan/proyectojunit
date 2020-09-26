package com.example.proyectojunit.parqueadero.dominio.servicio;

import com.example.proyectojunit.parqueadero.dominio.modelo.Registro;
import com.example.proyectojunit.parqueadero.dominio.modelo.Vehiculo;
import com.example.proyectojunit.parqueadero.dominio.repositorio.RepositorioRegistro;
import com.example.proyectojunit.parqueadero.dominio.testdatabuilder.RegistroTestDataBuilder;
import com.example.proyectojunit.parqueadero.dominio.testdatabuilder.VehiculoTestDataBuilder;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.MockitoAnnotations;

import java.util.Calendar;
import java.util.GregorianCalendar;

public class ServicioParqueaderoTest {
    @InjectMocks
    private ServicioParqueadero servicioParqueadero;

    @Mock
    private RepositorioRegistro repositorioRegistro;

    @BeforeEach
    public void init() {
        MockitoAnnotations.initMocks(this);
    }

    @Test
    public void validarConCostoExtraMoto() {
        Vehiculo vehiculo = new VehiculoTestDataBuilder().conTipo("MOTO").conPlaca("A4-B6").conCilindraje(2000).buil();

        int costo = this.servicioParqueadero.costoExtraMoto(vehiculo);

        Assertions.assertTrue(costo == 2000);
    }

    @Test
    public void validarSinCostoExtraMoto() {
        Vehiculo vehiculo = new VehiculoTestDataBuilder().conTipo("MOTO").conPlaca("A4-B6").conCilindraje(200).buil();

        int costo = this.servicioParqueadero.costoExtraMoto(vehiculo);

        Assertions.assertTrue(costo == 0);
    }

    @Test
    public void validarConAccesoPorPlacas() {
        Vehiculo vehiculo = new VehiculoTestDataBuilder().conTipo("MOTO").conPlaca("A4-B6").conCilindraje(200).buil();
        Calendar diaActual = new GregorianCalendar(2019, 5, 25, 20, 00);

        boolean acceso = this.servicioParqueadero.accesoPorPlacas(vehiculo, diaActual);

        Assertions.assertTrue(acceso);
    }

    @Test
    public void validarSinAccesoPorPlacas() {
        Vehiculo vehiculo = new VehiculoTestDataBuilder().conTipo("MOTO").conPlaca("A4-B6").conCilindraje(200).buil();
        Calendar diaActual = new GregorianCalendar(2019, 5, 24, 20, 00);

        boolean acceso = this.servicioParqueadero.accesoPorPlacas(vehiculo, diaActual);

        Assertions.assertFalse(acceso);
    }

    @Test
    public void validarCostoPorEstadiaCarro() {

        Vehiculo vehiculo = new VehiculoTestDataBuilder().conTipo("CARRO").buil();
        Calendar fechaActual = new GregorianCalendar(2019, 5, 24, 12, 00);
        Calendar fechaInicial = new GregorianCalendar(2019, 5, 24, 22, 00);
        Registro registro = new RegistroTestDataBuilder().conVehiculo(vehiculo).conFechaEntrada(fechaInicial).build();

        int costo = this.servicioParqueadero.costoPorEstadia(registro, fechaActual);

        Assertions.assertTrue(costo == 8000);
    }

    @Test
    public void validarCostoPorEstadiaMoto() {
        Vehiculo vehiculo = new VehiculoTestDataBuilder().conTipo("MOTO").conCilindraje(200).buil();
        Calendar fechaActual = new GregorianCalendar(2019, 5, 24, 12, 00);
        Calendar fechaInicial = new GregorianCalendar(2019, 5, 24, 22, 00);
        Registro registro = new RegistroTestDataBuilder().conVehiculo(vehiculo).conFechaEntrada(fechaInicial).build();

        int costo = this.servicioParqueadero.costoPorEstadia(registro, fechaActual);

        Assertions.assertTrue(costo == 4000);
    }

    @Test
    public void validarCostoPorEstadiaMotoConExtra() {
        Vehiculo vehiculo = new VehiculoTestDataBuilder().conTipo("MOTO").conCilindraje(600).buil();
        Calendar fechaActual = new GregorianCalendar(2019, 5, 24, 12, 00);
        Calendar fechaInicial = new GregorianCalendar(2019, 5, 24, 22, 00);
        Registro registro = new RegistroTestDataBuilder().conVehiculo(vehiculo).conFechaEntrada(fechaInicial).build();

        int costo = this.servicioParqueadero.costoPorEstadia(registro, fechaActual);

        Assertions.assertTrue(costo == 6000);
    }

}
