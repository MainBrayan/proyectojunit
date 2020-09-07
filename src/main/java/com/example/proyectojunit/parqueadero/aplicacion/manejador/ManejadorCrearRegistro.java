package com.example.proyectojunit.parqueadero.aplicacion.manejador;

import com.example.proyectojunit.parqueadero.dominio.excepcion.ParqueaderoExcepcion;
import com.example.proyectojunit.parqueadero.dominio.modelo.Registro;
import com.example.proyectojunit.parqueadero.dominio.servicio.ServicioCrearRegistro;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

@Component
public class ManejadorCrearRegistro {
    private ServicioCrearRegistro servicioCrearRegistro;

    @Autowired
    public ManejadorCrearRegistro(ServicioCrearRegistro servicioCrearRegistro) {
        this.servicioCrearRegistro = servicioCrearRegistro;
    }

    public Registro ejecutar(Registro registro) throws ParqueaderoExcepcion {
        return this.servicioCrearRegistro.ejecutar(registro);
    }
}
