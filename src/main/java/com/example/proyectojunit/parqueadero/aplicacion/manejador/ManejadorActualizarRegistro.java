package com.example.proyectojunit.parqueadero.aplicacion.manejador;

import com.example.proyectojunit.parqueadero.dominio.excepcion.ParqueaderoExcepcion;
import com.example.proyectojunit.parqueadero.dominio.modelo.Registro;
import com.example.proyectojunit.parqueadero.dominio.servicio.ServicioActualizarRegistro;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

@Component
public class ManejadorActualizarRegistro {
    private ServicioActualizarRegistro servicioActualizarRegistro;

    @Autowired
    public ManejadorActualizarRegistro(ServicioActualizarRegistro servicioActualizarRegistro) {
        this.servicioActualizarRegistro = servicioActualizarRegistro;
    }

    public Registro ejecutar(Registro registro) throws ParqueaderoExcepcion {
        return this.servicioActualizarRegistro.ejecutar(registro);
    }
}
