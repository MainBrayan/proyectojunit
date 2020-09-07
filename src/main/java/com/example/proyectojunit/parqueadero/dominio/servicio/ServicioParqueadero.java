package com.example.proyectojunit.parqueadero.dominio.servicio;

import com.example.proyectojunit.parqueadero.dominio.modelo.Registro;
import com.example.proyectojunit.parqueadero.dominio.modelo.Vehiculo;
import com.example.proyectojunit.parqueadero.dominio.repositorio.RepositorioRegistro;

import java.util.Calendar;

public class ServicioParqueadero {
    private RepositorioRegistro repositorioRegistro;
    private static String carro = "CARRO";
    private static String moto = "MOTO";

    public ServicioParqueadero(RepositorioRegistro repositorioRegistro) {
        this.repositorioRegistro = repositorioRegistro;
    }

    public boolean existeEnParqueadero(String placa) {
        return repositorioRegistro.obtenerRegistroPorPlaca(placa);
    }

    public int costoExtraMoto(Vehiculo vehiculo) {
        return vehiculo.getCilindraje() > 500 ? 2000 : 0;
    }

    public boolean accesoPorPlacas(Vehiculo vehiculo, Calendar diaActual) {
        boolean placaIniciaConA = vehiculo.getPlaca().substring(0).startsWith("A");
        boolean accesoPermitido = true;
        boolean accesoDenegado = false;
        if (placaIniciaConA) {
            return diaActual.get(Calendar.DAY_OF_WEEK) < 3 ? accesoDenegado : accesoPermitido;
        } else {
            return accesoPermitido;
        }
    }

    public int costoPorEstadia(Registro registro, Calendar fechaActual) {
        int costo = 0;
        if (registro.getVehiculo().getTipo().equals(carro)) {
            costo += calcularCostoDiasHora(8000, 1000, registro.getFechaEntrada(), fechaActual);
        } else if(registro.getVehiculo().getTipo().equals(moto)) {
            costo += calcularCostoDiasHora(4000, 500, registro.getFechaEntrada(), fechaActual);
            costo += costoExtraMoto(registro.getVehiculo());
        }
        return costo;
    }

    public int calcularCostoDiasHora(int valorDias, int valorHoras, Calendar fechaInicial, Calendar fechaActual) {
        long mili = 86400000;
        int horas;
        int dias;
        double diferenciasHoras = (double) fechaActual.getTimeInMillis() - fechaInicial.getTimeInMillis();
        diferenciasHoras = diferenciasHoras / mili;
        diferenciasHoras = diferenciasHoras * 24;
        dias = Math.abs((int) diferenciasHoras / 24);
        horas = Math.abs((int) diferenciasHoras % 24);
        int costoHoras = horas >= 9 ? valorDias : valorHoras * horas;
        return dias == 0 && horas == 0 ? valorHoras : (valorDias * dias) + (costoHoras);
    }
}
