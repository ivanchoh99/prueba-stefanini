package org.stefanini.backstefanini.model.enums;

import lombok.AllArgsConstructor;
import lombok.Getter;
import org.springframework.validation.BindException;
import org.springframework.web.bind.MethodArgumentNotValidException;

@Getter
@AllArgsConstructor
public enum TipoDocumento {
    C("Cedula de ciudadania"), P("Pasaporte");

    private final String nombre;
}
