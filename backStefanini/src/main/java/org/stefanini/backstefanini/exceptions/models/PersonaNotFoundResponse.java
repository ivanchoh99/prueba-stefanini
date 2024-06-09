package org.stefanini.backstefanini.exceptions.models;

public record PersonaNotFoundResponse
        (String mensaje,
         String tipoDocuemto,
         long numeroDocumento) {
}
