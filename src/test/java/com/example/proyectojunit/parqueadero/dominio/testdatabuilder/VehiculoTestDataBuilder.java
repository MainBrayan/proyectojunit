package com.example.proyectojunit.parqueadero.dominio.testdatabuilder;

import com.example.proyectojunit.parqueadero.dominio.modelo.Vehiculo;

public class VehiculoTestDataBuilder {
    private String tipo;
    private String placa;
    private int cilindraje;

    public VehiculoTestDataBuilder() {
        this.tipo = "MOTO";
        this.placa = "B58-123";
        this.cilindraje = 2000;
    }

    public VehiculoTestDataBuilder conTipo(String tipo) {
        this.tipo = tipo;
        return this;
    }
    public VehiculoTestDataBuilder conPlaca(String placa) {
        this.placa = placa;
        return this;
    }

    public VehiculoTestDataBuilder conCilindraje(int cilindraje) {
        this.cilindraje = cilindraje;
        return this;
    }

    public Vehiculo buil() {
        return new Vehiculo(tipo, placa, cilindraje);
    }
}
