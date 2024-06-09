package org.stefanini.backstefanini.exceptions;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.mockito.InjectMocks;
import org.mockito.MockitoAnnotations;
import org.springframework.http.ResponseEntity;
import org.stefanini.backstefanini.exceptions.models.PersonaNotFoundResponse;
import org.stefanini.backstefanini.models.enums.TipoDocumento;

import static org.junit.jupiter.api.Assertions.assertEquals;

class GlobalExceptionHandlerTest {

    @InjectMocks
    private GlobalExceptionHandler handler;


    @BeforeEach
    void setUp() {
        MockitoAnnotations.openMocks(this);
    }

    @Test
    @DisplayName("Validar el retorno de la exception de persona no encontrada")
    void handlerPersonaNotFoundException() {
        PersonaNotFoundException ex = new PersonaNotFoundException(TipoDocumento.C, 22222222);
        PersonaNotFoundResponse response = new PersonaNotFoundResponse("Persona no encontrada", ex.getTipoDocumento(), ex.getNumeroDocumento());
        ResponseEntity<PersonaNotFoundResponse> respuesta = handler.handlerPersonaNotFoundException(ex);
        assertEquals(ResponseEntity.status(404).body(response), respuesta);
    }
}