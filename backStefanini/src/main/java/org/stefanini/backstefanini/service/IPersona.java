package org.stefanini.backstefanini.service;

import org.springframework.web.bind.MethodArgumentNotValidException;
import org.stefanini.backstefanini.model.PersonaRequest;
import org.stefanini.backstefanini.model.dto.PersonaDTO;

public interface IPersona {
    PersonaDTO getPersona(PersonaRequest request) throws MethodArgumentNotValidException;
}
