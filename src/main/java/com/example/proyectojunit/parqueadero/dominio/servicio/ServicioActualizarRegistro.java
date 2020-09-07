package com.example.proyectojunit.parqueadero.dominio.servicio;

import com.example.proyectojunit.parqueadero.dominio.excepcion.ParqueaderoExcepcion;
import com.example.proyectojunit.parqueadero.dominio.excepcion.ParqueaderoExcepcionTipos;
import com.example.proyectojunit.parqueadero.dominio.modelo.Registro;
import com.example.proyectojunit.parqueadero.dominio.repositorio.RepositorioRegistro;

import java.util.Calendar;

public class ServicioActualizarRegistro {
    private RepositorioRegistro repositorioRegistro;
    private ServicioParqueadero servicioParqueadero;

    private static final String NO_EXISTE_EN_PARQUEADERO = "El vehiculo pedido para salida no se encuentra en el parqueadero";

    public ServicioActualizarRegistro(RepositorioRegistro repositorioRegistro, ServicioParqueadero servicioParqueadero) {
        this.repositorioRegistro = repositorioRegistro;
        this.servicioParqueadero = servicioParqueadero;
    }

    public Registro ejecutar(Registro registro) throws ParqueaderoExcepcion {
        this.validarExistenciaEnParqueadero(registro.getVehiculo().getPlaca());
        registro.setFechaSalida(Calendar.getInstance());
        registro.setCostoEstadia(this.servicioParqueadero.costoPorEstadia(registro, registro.getFechaSalida()));
        this.repositorioRegistro.actualizar(registro);
        return registro;
    }

    public void validarExistenciaEnParqueadero(String placa) throws ParqueaderoExcepcion {
        boolean existeEnParqueadero = servicioParqueadero.existeEnParqueadero(placa);
        if (!existeEnParqueadero) {
            throw new ParqueaderoExcepcion(ParqueaderoExcepcionTipos.EXISTENCIA_PARQUEADERO, NO_EXISTE_EN_PARQUEADERO);
        }
    }
}
