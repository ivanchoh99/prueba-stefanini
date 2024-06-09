package org.stefanini.backstefanini.services;

import org.stefanini.backstefanini.models.Persona;
import org.stefanini.backstefanini.models.enums.TipoDocumento;

public interface IPersona {
    Persona getPersona(TipoDocumento tipoDocumento, long numeroDocumento);
}
