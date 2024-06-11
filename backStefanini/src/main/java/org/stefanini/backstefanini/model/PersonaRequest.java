package org.stefanini.backstefanini.model;

import jakarta.validation.constraints.*;

public record PersonaRequest(
        @NotNull(message = "No puede estar vació")
        @Pattern(regexp = "^([P|C])$", message = "Tipo de documento no valido")
        String tipoDocumento,
        @NotNull(message = "El numero de documento no puede estar vació")
        @Min(value = 10000000, message = "El numero de documento debe estar entre 8 y 10 dígitos")
        @Max(value = 9999999999L, message = "El numero de documento debe estar entre 8 y 10 dígitos")
        Long numeroDocumento) {
}
