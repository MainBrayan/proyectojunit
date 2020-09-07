package com.example.proyectojunit.parqueadero.dominio.repositorio;

import com.example.proyectojunit.parqueadero.dominio.modelo.Registro;

import java.util.Collection;

public interface RepositorioRegistro {
    Collection<Registro> listar();
    void crear(Registro registro);
    Registro actualizar(Registro registro);
    boolean obtenerRegistroPorPlaca(String placa);
}
