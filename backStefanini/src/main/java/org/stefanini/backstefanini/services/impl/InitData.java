package org.stefanini.backstefanini.services.impl;

import org.springframework.stereotype.Repository;
import org.stefanini.backstefanini.models.Persona;
import org.stefanini.backstefanini.models.enums.TipoDocumento;

import java.util.List;

@Repository
public class InitData {
    public List<Persona> crearPersonas() {
        Persona persona1 = new Persona(1075321508, TipoDocumento.P, "Ivan", "Hernan", "Carvajal", "Acevedo", 3173866664L, "Calle 7", "Bogota");
        Persona persona2 = new Persona(54161469, TipoDocumento.C, "Andrea", "", "Valesuela", "Cordoba", 3176782741L, "Carrera 12", "Neiva");
        Persona persona3 = new Persona(23445322, TipoDocumento.C, "Carlos", "Alberto", "Gomez", "Perez", 3074752341L, "Diagonal 24, junto a la playa", "Cartagena");
        Persona persona4 = new Persona(555231245, TipoDocumento.P, "Laura", "Lucia", "Lara", "Lumbera", 3000752001L, "Transversal 40", "Medellin");
        return List.of(persona1, persona2, persona3, persona4);
    }
}
