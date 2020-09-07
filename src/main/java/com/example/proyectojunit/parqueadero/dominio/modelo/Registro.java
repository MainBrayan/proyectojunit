package com.example.proyectojunit.parqueadero.dominio.modelo;

import java.util.Calendar;

public class Registro {
    private Vehiculo vehiculo;
    private Calendar fechaEntrada;
    private Calendar fechaSalida;
    private double costoEstadia;

    public Registro(Vehiculo vehiculo, Calendar fechaEntrada) {
        this.vehiculo = vehiculo;
        this.fechaEntrada = fechaEntrada;
        this.fechaSalida = null;
        this.costoEstadia = 0;
    }

    public Vehiculo getVehiculo() {
        return vehiculo;
    }
    public void setVehiculo(Vehiculo vehiculo) {
        this.vehiculo = vehiculo;
    }
    public Calendar getFechaEntrada() {
        return fechaEntrada;
    }
    public void setFechaEntrada(Calendar fechaEntrada) {
        this.fechaEntrada = fechaEntrada;
    }
    public Calendar getFechaSalida() {
        return fechaSalida;
    }
    public void setFechaSalida(Calendar fechaSalida) {
        this.fechaSalida = fechaSalida;
    }
    public double getCostoEstadia() {
        return costoEstadia;
    }
    public void setCostoEstadia(double costoEstadia) {
        this.costoEstadia = costoEstadia;
    }
}
