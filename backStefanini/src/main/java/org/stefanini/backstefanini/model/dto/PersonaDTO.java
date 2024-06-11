package org.stefanini.backstefanini.model.dto;

import org.stefanini.backstefanini.model.Persona;

public record PersonaDTO(String primerNombre, String segundoNombre, String primerApellido, String segundoApellido, long telefono, String direccion,
                         String ciudadDeResidencia) {
    public PersonaDTO(Persona persona) {
        this(persona.getPrimerNombre(), persona.getSegundoNombre(), persona.getPrimerApellido(), persona.getSegundoApellido(), persona.getTelefono(), persona.getDireccion(), persona.getCiudadResidencia());
    }
}
