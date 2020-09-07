package com.example.proyectojunit.parqueadero.infraestructura.adaptador.servicio;

import com.example.proyectojunit.parqueadero.dominio.servicio.ServicioActualizarRegistro;
import com.example.proyectojunit.parqueadero.dominio.servicio.ServicioCrearRegistro;
import com.example.proyectojunit.parqueadero.dominio.servicio.ServicioParqueadero;
import com.example.proyectojunit.parqueadero.infraestructura.adaptador.repositorio.RepositorioRegistroEnMemoria;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class BeanServicio {
    @Bean
    public ServicioCrearRegistro servicioCrearRegistro() {
        return new ServicioCrearRegistro(new RepositorioRegistroEnMemoria(),
                new ServicioParqueadero(new RepositorioRegistroEnMemoria()));
    }

    @Bean
    public ServicioActualizarRegistro servicioActualizarRegistro() {
        return new ServicioActualizarRegistro(new RepositorioRegistroEnMemoria(),
                new ServicioParqueadero(new RepositorioRegistroEnMemoria()));
    }
}
