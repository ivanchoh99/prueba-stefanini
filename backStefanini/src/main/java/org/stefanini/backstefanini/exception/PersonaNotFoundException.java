package org.stefanini.backstefanini.exception;

import lombok.Getter;
import org.stefanini.backstefanini.model.enums.TipoDocumento;

@Getter
public class PersonaNotFoundException extends RuntimeException {
    private final String tipoDocumento;
    private final long numeroDocumento;

    public PersonaNotFoundException(TipoDocumento tipoDocumento, long numeroDocumento) {
        this.tipoDocumento = tipoDocumento.getNombre();
        this.numeroDocumento = numeroDocumento;
    }
}
