package com.example.proyectojunit.simpleassert;

import java.util.HashMap;
import java.util.Map;

public class Bazinga {

    public Map<String, String> reglas;

    public Bazinga() {
        reglas = buildElements();
    }

    public String duelo(String sheldon, String raj) {
        String ganador = "Jugar de nuevo";
        if (reglas.get(sheldon).contains(raj)) {
            ganador = "Sheldon";
        } else if (reglas.get(raj).contains(sheldon)) {
            ganador = "Raj";
        }
        return ganador;
    }

    public void recargarReglas () {
        this.reglas = buildElements();
        System.out.println("las reglas se cargaron de nuevo");
    }

    private Map<String, String> buildElements() {
        Map<String, String> elements = new HashMap<>();
        elements.put("tijeras", "papel lagarto");
        elements.put("papel", "piedra Spock");
        elements.put("piedra", "lagarto tijeras");
        elements.put("lagarto", "Spock papel");
        elements.put("Spock", "tijeras piedra");
        return elements;
    }
}
