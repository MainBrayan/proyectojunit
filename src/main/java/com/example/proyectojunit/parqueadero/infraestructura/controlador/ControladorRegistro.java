package com.example.proyectojunit.parqueadero.infraestructura.controlador;

import com.example.proyectojunit.parqueadero.aplicacion.manejador.ManejadorActualizarRegistro;
import com.example.proyectojunit.parqueadero.aplicacion.manejador.ManejadorCrearRegistro;
import com.example.proyectojunit.parqueadero.aplicacion.manejador.ManejadorListarRegistros;
import com.example.proyectojunit.parqueadero.dominio.excepcion.ParqueaderoExcepcion;
import com.example.proyectojunit.parqueadero.dominio.modelo.Registro;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.Collection;

@RestController
@RequestMapping("/registro")
public class ControladorRegistro {
    private ManejadorActualizarRegistro manejadorActualizarRegistro;
    private ManejadorCrearRegistro manejadorCrearRegistro;
    private ManejadorListarRegistros manejadorListarRegistros;

    @Autowired
    public ControladorRegistro(ManejadorListarRegistros manejadorListarRegistros,
                               ManejadorCrearRegistro manejadorCrearRegistro, ManejadorActualizarRegistro manejadorActualizarRegistro) {
        this.manejadorCrearRegistro = manejadorCrearRegistro;
        this.manejadorListarRegistros = manejadorListarRegistros;
        this.manejadorActualizarRegistro = manejadorActualizarRegistro;
    }

    @GetMapping(value = "listar")
    public ResponseEntity<Collection<Registro>> listar() {
        return new ResponseEntity<>(this.manejadorListarRegistros.ejecutar(), HttpStatus.OK);
    }

    @PostMapping(value = "crear")
    public ResponseEntity<Registro> crear(@RequestBody Registro registro) throws ParqueaderoExcepcion {
        return new ResponseEntity<>(this.manejadorCrearRegistro.ejecutar(registro), HttpStatus.OK);
    }

    @PostMapping(value = "actualizar")
    public ResponseEntity<Registro> actualizar(@RequestBody Registro registro) throws ParqueaderoExcepcion {
        return new ResponseEntity<>(this.manejadorActualizarRegistro.ejecutar(registro), HttpStatus.OK);
    }
}
