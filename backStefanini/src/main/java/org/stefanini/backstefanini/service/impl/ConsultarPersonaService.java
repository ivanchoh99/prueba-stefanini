package org.stefanini.backstefanini.service.impl;

import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;
import org.springframework.web.bind.MethodArgumentNotValidException;
import org.stefanini.backstefanini.model.Persona;
import org.stefanini.backstefanini.model.PersonaRequest;
import org.stefanini.backstefanini.model.dto.PersonaDTO;
import org.stefanini.backstefanini.service.IDataBase;
import org.stefanini.backstefanini.service.IPersona;

@Slf4j
@Service
@RequiredArgsConstructor
public class ConsultarPersonaService implements IPersona {

    private final IDataBase personaDBService;

    @Override
    public PersonaDTO getPersona(PersonaRequest request) throws MethodArgumentNotValidException {
        Persona persona = personaDBService.getEntityByTipoAndId(request.tipoDocumento(), request.numeroDocumento());
        log.info("Usuario {} obtenido", request.numeroDocumento());
        return new PersonaDTO(persona);
    }
}
