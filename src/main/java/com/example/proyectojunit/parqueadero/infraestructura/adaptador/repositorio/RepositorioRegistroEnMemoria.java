package com.example.proyectojunit.parqueadero.infraestructura.adaptador.repositorio;

import com.example.proyectojunit.parqueadero.dominio.modelo.Registro;
import com.example.proyectojunit.parqueadero.dominio.modelo.Vehiculo;
import com.example.proyectojunit.parqueadero.dominio.repositorio.RepositorioRegistro;
import org.springframework.stereotype.Repository;

import java.util.*;
import java.util.concurrent.ConcurrentHashMap;

@Repository
public class RepositorioRegistroEnMemoria implements RepositorioRegistro {
    private static ConcurrentHashMap<String, Registro> registros;
    static {
        registros = new ConcurrentHashMap<>();
        registros.put(UUID.randomUUID().toString(),
                new Registro(new Vehiculo("CARRO", "AB-12", 200), new GregorianCalendar(2019, 5, 22, 20, 0)));
    }

    @Override
    public Collection<Registro> listar() {
        return getRegistros();
    }

    @Override
    public void crear(Registro registro) {
        registros.put(UUID.randomUUID().toString(), registro);
    }

    @Override
    public boolean obtenerRegistroPorPlaca(String placa) {
        return getRegistros().stream()
                .anyMatch(fila -> fila.getVehiculo().getPlaca().equals(placa) && fila.getFechaSalida() == null);
    }

    @Override
    public Registro actualizar(Registro registro) {
        for(Registro iterable: getRegistros()) {
            if(iterable.getVehiculo().getPlaca().equals(registro.getVehiculo().getPlaca()) && iterable.getFechaSalida() == null) {
                iterable.setVehiculo(registro.getVehiculo());
                iterable.setFechaSalida(registro.getFechaSalida());
                iterable.setCostoEstadia(registro.getCostoEstadia());
                break;
            }
        }
        return registro;
    }

    private static Collection<Registro> getRegistros() {
        return registros.values();
    }
}
