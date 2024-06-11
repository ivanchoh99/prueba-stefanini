package org.stefanini.backstefanini.exception.model;

public record PersonaNotFoundResponse
        (String mensaje,
         String tipoDocuemto,
         long numeroDocumento) {
}
