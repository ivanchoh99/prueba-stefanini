package org.stefanini.backstefanini.models.dto;

import jakarta.validation.constraints.*;

public record PersonaRequest(
        @NotNull(message = "No puede estar vació")
        @Size(min = 1, max = 1, message = "El tipo de documento debe ser un solo carácter")
        String tipoDocumento,
        @NotNull(message = "El numero de documento no puede estar vació")
        @Min(value = 10000000, message = "El numero de documento debe estar entre 8 y 10 dígitos")
        @Max(value = 9999999999L, message = "El numero de documento debe estar entre 8 y 10 dígitos")
        Long numeroDocumento) {
}
