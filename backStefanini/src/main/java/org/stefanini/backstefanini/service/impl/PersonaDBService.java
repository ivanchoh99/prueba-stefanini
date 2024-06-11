package org.stefanini.backstefanini.service.impl;

import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;
import org.springframework.web.bind.MethodArgumentNotValidException;
import org.stefanini.backstefanini.Util;
import org.stefanini.backstefanini.exception.PersonaNotFoundException;
import org.stefanini.backstefanini.model.Persona;
import org.stefanini.backstefanini.model.enums.TipoDocumento;
import org.stefanini.backstefanini.repository.PersonaRepository;
import org.stefanini.backstefanini.service.IDataBase;

@Slf4j
@Service
@RequiredArgsConstructor
public class PersonaDBService implements IDataBase {

    private final PersonaRepository repo;
    private final Util utils;

    @Override
    public Persona getEntityByTipoAndId(String tipoDocumentoParam, long numeroDocumento) throws MethodArgumentNotValidException {
        log.info("Buscando usuario con {} y numero de documento {}", tipoDocumentoParam, numeroDocumento);
        TipoDocumento tipoDocumento = utils.validateTipoDocumento(tipoDocumentoParam);
        return repo.findByIdAndTipoDocumento(numeroDocumento,tipoDocumento)
                .orElseThrow(() -> new PersonaNotFoundException(tipoDocumento, numeroDocumento));
    }
}
