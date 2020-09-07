package com.example.proyectojunit.parqueadero.dominio.servicio;

import com.example.proyectojunit.parqueadero.dominio.excepcion.ParqueaderoExcepcion;
import com.example.proyectojunit.parqueadero.dominio.excepcion.ParqueaderoExcepcionTipos;
import com.example.proyectojunit.parqueadero.dominio.modelo.Registro;
import com.example.proyectojunit.parqueadero.dominio.modelo.Vehiculo;
import com.example.proyectojunit.parqueadero.dominio.repositorio.RepositorioRegistro;

import java.util.Calendar;

public class ServicioCrearRegistro {
    private RepositorioRegistro repositorioRegistro;
    private ServicioParqueadero servicioParqueadero;

    private static final String YA_EXISTE_EN_PARQUEADERO = "Este Vehiculo ya se encuentra en el parqueadero";
    private static final String ACCESO_NEGADO_POR_PLACAS = "Las placas que comienzan con A no pueden ingresar los lunes y domingos";

    public ServicioCrearRegistro(RepositorioRegistro repositorioRegistro, ServicioParqueadero servicioParqueadero) {
        this.repositorioRegistro = repositorioRegistro;
        this.servicioParqueadero = servicioParqueadero;
    }

    public Registro ejecutar(Registro registro) throws ParqueaderoExcepcion {
        this.validarAccesoPorPlacas(registro.getVehiculo(), registro.getFechaEntrada());
        this.validarExistenciaPlacaSinSalida(registro.getVehiculo().getPlaca());
        this.repositorioRegistro.crear(registro);
        return registro;
    }

    public void validarExistenciaPlacaSinSalida(String placa) throws ParqueaderoExcepcion {
        boolean estaEnParqueadero = servicioParqueadero.existeEnParqueadero(placa);
        if(estaEnParqueadero) {
            throw new ParqueaderoExcepcion(ParqueaderoExcepcionTipos.EXISTENCIA_PARQUEADERO, YA_EXISTE_EN_PARQUEADERO);
        }
    }

    public void validarAccesoPorPlacas(Vehiculo vehiculo, Calendar fechaEntrada) throws ParqueaderoExcepcion {
        boolean entradaParqueadero = this.servicioParqueadero.accesoPorPlacas(vehiculo, fechaEntrada);
        if(!entradaParqueadero) {
            throw new ParqueaderoExcepcion(ParqueaderoExcepcionTipos.ACCESO_PLACAS, ACCESO_NEGADO_POR_PLACAS);
        }
    }

}
