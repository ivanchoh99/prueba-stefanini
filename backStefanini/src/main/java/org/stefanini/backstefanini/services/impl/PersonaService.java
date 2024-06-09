package org.stefanini.backstefanini.services.impl;

import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;
import org.stefanini.backstefanini.exceptions.PersonaNotFoundException;
import org.stefanini.backstefanini.models.Persona;
import org.stefanini.backstefanini.models.enums.TipoDocumento;
import org.stefanini.backstefanini.services.IPersona;

import java.util.List;

@Slf4j
@Service
public class PersonaService implements IPersona {

    private final InitData initData;

    public PersonaService(InitData initData) {
        this.initData = initData;
    }

    @Override
    public Persona getPersona(TipoDocumento tipoDocumento, long numeroDocumento) {
        List<Persona> personas = initData.crearPersonas();
        log.info("Buscando usuario con {} y numero de documento {}", tipoDocumento.getNombre(), numeroDocumento);
        return personas.stream()
                .filter(persona -> persona.getTipoDocumento() == tipoDocumento && persona.getId() == numeroDocumento)
                .findFirst()
                .orElseThrow(()->new PersonaNotFoundException(tipoDocumento,numeroDocumento));
    }


}
