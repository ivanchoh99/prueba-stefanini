package org.stefanini.backstefanini.service;

import org.springframework.web.bind.MethodArgumentNotValidException;
import org.stefanini.backstefanini.model.Persona;

public interface IDataBase {

    Persona getEntityByTipoAndId(String tipoDocumento, long numeroDocumento) throws MethodArgumentNotValidException;
}
