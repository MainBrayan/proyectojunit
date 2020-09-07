package com.example.proyectojunit.simpleassert;

import java.util.HashMap;
import java.util.Map;

public class Bazinga {

    public static Map<String, String> reglas = buildElements();

    public String duelo(String sheldon, String raj) {
        String ganador = "Jugar de nuevo";
        if (reglas.get(sheldon).contains(raj)) {
            ganador = "Sheldon";
        } else if (reglas.get(raj).contains(sheldon)) {
            ganador = "Raj";
        }
        return ganador;
    }

    public static Map<String, String> buildElements() {
        Map<String, String> elements = new HashMap<>();
        elements.put("tijeras", "papel lagarto");
        elements.put("papel", "piedra Spock");
        elements.put("piedra", "lagarto tijeras");
        elements.put("lagarto", "Spock papel");
        elements.put("Spock", "tijeras pedra");
        return elements;
    }
}
