package org.stefanini.backstefanini.services.impl;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.stefanini.backstefanini.models.Persona;
import org.stefanini.backstefanini.models.enums.TipoDocumento;

import java.util.Arrays;
import java.util.List;
import java.util.Optional;

import static org.junit.jupiter.api.Assertions.*;

class InitDataTest {


    @Test
    @DisplayName("Revisar que el listado de usuarios no sean nulos")
    void crearPersonas() {
        InitData initData = new InitData();
        List<Persona> personas = initData.crearPersonas();
        assertNotNull(personas);
    }

    @Test
    void crearPersona() {
        InitData initData = new InitData();
        List<Persona> personas = initData.crearPersonas();
        Persona persona = new Persona(1075321508, TipoDocumento.P, "Ivan", "Hernan", "Carvajal", "Acevedo", 3173866664L, "Calle 7", "Bogota");
        assertEquals(personas.get(0), persona);
    }

    @Test
    @DisplayName("Revisar que los usuarios no sean nulos")
    void validarUsuariosNulos(){
        InitData initData = new InitData();
        List<Persona> personas = initData.crearPersonas();
        boolean usuarioNulo = false;
        for (Persona persona : personas) {
            if(persona == null){
                usuarioNulo = true;
            }
        }
        assertFalse(usuarioNulo);
    }

    @Test
    @DisplayName("Verificar si los datos de los usuarios son correctos")
    void validarPersonasCreadas() {
        InitData initData = new InitData();
        List<Persona> personas = initData.crearPersonas();
        Persona result = null;
        for (Persona persona : personas) {
            if (persona.getTipoDocumento() == TipoDocumento.C && persona.getId() == 23445322) {
                result = persona;
            }
        }
        assertEquals(23445322, result != null ? result.getId() : 0);
        assertEquals(TipoDocumento.C, result != null ? result.getTipoDocumento() : null);
    }
}