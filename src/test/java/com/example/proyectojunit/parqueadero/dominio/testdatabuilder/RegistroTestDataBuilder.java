package com.example.proyectojunit.parqueadero.dominio.testdatabuilder;

import com.example.proyectojunit.parqueadero.dominio.modelo.Registro;
import com.example.proyectojunit.parqueadero.dominio.modelo.Vehiculo;

import java.util.Calendar;
import java.util.GregorianCalendar;

public class RegistroTestDataBuilder {
    private Vehiculo vehiculo;
    private Calendar fechaEntrada;

    public RegistroTestDataBuilder() {
        super();
        this.vehiculo = new Vehiculo("CARRO", "A50", 500);
        this.fechaEntrada = new GregorianCalendar(2019, 6, 24, 20, 00);
    }

    public RegistroTestDataBuilder conVehiculo(Vehiculo vehiculo) {
        this.vehiculo = vehiculo;
        return this;
    }

    public RegistroTestDataBuilder conFechaEntrada(Calendar fechaEntrada) {
        this.fechaEntrada = fechaEntrada;
        return this;
    }

    public Registro build() {
        return new Registro(vehiculo, fechaEntrada);
    }
}
