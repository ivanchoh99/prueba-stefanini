package org.stefanini.backstefanini.exceptions;

import lombok.Getter;
import org.stefanini.backstefanini.models.enums.TipoDocumento;

@Getter
public class PersonaNotFoundException extends RuntimeException {
    private final String tipoDocumento;
    private final long numeroDocumento;

    public PersonaNotFoundException(TipoDocumento tipoDocumento, long numeroDocumento) {
        this.tipoDocumento = tipoDocumento.getNombre();
        this.numeroDocumento = numeroDocumento;
    }
}
