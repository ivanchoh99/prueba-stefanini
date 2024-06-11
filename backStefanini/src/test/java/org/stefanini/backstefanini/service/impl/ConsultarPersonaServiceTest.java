package org.stefanini.backstefanini.service.impl;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.mockito.MockitoAnnotations;
import org.springframework.web.bind.MethodArgumentNotValidException;
import org.stefanini.backstefanini.model.Persona;
import org.stefanini.backstefanini.model.PersonaRequest;
import org.stefanini.backstefanini.model.dto.PersonaDTO;
import org.stefanini.backstefanini.model.enums.TipoDocumento;

import static org.junit.jupiter.api.Assertions.*;

class ConsultarPersonaServiceTest {

    @Mock
    private PersonaDBService personaDBService;

    @InjectMocks
    private ConsultarPersonaService personaService;

    @BeforeEach
    void setUp() {
        MockitoAnnotations.openMocks(this);
    }

    @Test
    @DisplayName("Test el metodo getPersona ejecucion")
    void testGetPersona() throws MethodArgumentNotValidException {
        PersonaRequest request = new PersonaRequest("P", 1075321508L);
        Persona personaMock = new Persona(1075321508, TipoDocumento.P,null, null, null, null, 3173866664L, null,null);
        Mockito.when(personaDBService.getEntityByTipoAndId("P", 1075321508L)).thenReturn(personaMock);
        PersonaDTO personaDTO = personaService.getPersona(request);
        assertNotNull(personaDTO);
    }

    @Test
    @DisplayName("Test correcta ejecucion cuando no se encuentra persona")
    void testGetPersonaNotFound() throws MethodArgumentNotValidException {
        PersonaRequest request = new PersonaRequest("P", 1075321508L);
        Mockito.when(personaDBService.getEntityByTipoAndId("P", 1075321508L)).thenThrow(MethodArgumentNotValidException.class);
        assertThrows(MethodArgumentNotValidException.class, () -> personaService.getPersona(request));
    }

}