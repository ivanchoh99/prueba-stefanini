package org.stefanini.backstefanini.models.enums;

import lombok.AllArgsConstructor;
import lombok.Getter;

@Getter
@AllArgsConstructor
public enum TipoDocumento {
    C("Cedula de ciudadania"), P("Pasaporte");

    private final String nombre;
    public static TipoDocumento getTipoDocumento(String charTipo) {
        String charString = charTipo.toUpperCase();
        return TipoDocumento.valueOf(charString);
    }
}
