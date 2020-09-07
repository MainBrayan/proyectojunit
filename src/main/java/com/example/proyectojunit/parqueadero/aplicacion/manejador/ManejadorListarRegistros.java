package com.example.proyectojunit.parqueadero.aplicacion.manejador;

import com.example.proyectojunit.parqueadero.dominio.modelo.Registro;
import com.example.proyectojunit.parqueadero.dominio.repositorio.RepositorioRegistro;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.util.Collection;

@Component
public class ManejadorListarRegistros {
    private RepositorioRegistro repositorioRegistro;

    @Autowired
    public ManejadorListarRegistros(RepositorioRegistro daoRegistro) {
        this.repositorioRegistro = daoRegistro;
    }

    public Collection<Registro> ejecutar() {
        return this.repositorioRegistro.listar();
    }
}
