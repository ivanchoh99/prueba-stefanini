package org.stefanini.backstefanini.services.impl;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.MockitoAnnotations;
import org.stefanini.backstefanini.exceptions.PersonaNotFoundException;
import org.stefanini.backstefanini.models.Persona;
import org.stefanini.backstefanini.models.enums.TipoDocumento;

import java.util.Arrays;
import java.util.Collections;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertThrows;
import static org.mockito.Mockito.when;

class PersonaServiceTest {

    @InjectMocks
    private PersonaService personaService;

    @Mock
    private InitData initData;

    @BeforeEach
    void setUp() {
        MockitoAnnotations.openMocks(this);
        when(initData.crearPersonas()).thenReturn(Arrays.asList(
                new Persona(1075321508, TipoDocumento.P, "Ivan", "Hernan", "Carvajal", "Acevedo", 3173866664L, "Calle 7", "Bogota"),
                new Persona(54161469, TipoDocumento.C, "Andrea", "", "Valesuela", "Cordoba", 3176782741L, "Carrera 12", "Neiva"),
                new Persona(23445322, TipoDocumento.C, "Carlos", "Alberto", "Gomez", "Perez", 3074752341L, "Diagonal 24, junto a la playa", "Cartagena"),
                new Persona(555231245, TipoDocumento.P, "Laura", "Lucia", "Lara", "Lumbera", 3000752001L, "Transversal 40", "Medellin")
        ));
    }

    @Test
    @DisplayName("Realizar el proceso de búsqueda de persona")
    void getPersona() {
        Persona test = new Persona(23445322, TipoDocumento.C, "Carlos", "Alberto", "Gomez", "Perez", 3074752341L, "Diagonal 24, junto a la playa", "Cartagena");
        Persona result = personaService.getPersona(TipoDocumento.C, 23445322);
        assertEquals(test, result);
    }


    @Test
    @DisplayName("Ejecución correcta cuando no encuentra una persona")
    void testGetPersonaNoExistente() {
        assertThrows(PersonaNotFoundException.class, () -> personaService.getPersona(TipoDocumento.P, 22222222));
    }
}