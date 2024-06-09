package org.stefanini.backstefanini.models.dto;

import org.stefanini.backstefanini.models.Persona;

public record PersonaResponse(String primerNombre, String segundoNombre, String primerApellido, String segundoApellido, long telefono, String direccion,
                              String ciudadDeResidencia) {
    public PersonaResponse(Persona persona) {
        this(persona.getPrimerNombre(), persona.getSegundoNombre(), persona.getPrimerApellido(), persona.getSegundoApellido(), persona.getTelefono(), persona.getDireccion(), persona.getCiudadResidencia());
    }
}
