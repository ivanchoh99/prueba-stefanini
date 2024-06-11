package org.stefanini.backstefanini.model;

import jakarta.persistence.*;
import lombok.*;
import lombok.extern.slf4j.Slf4j;
import org.stefanini.backstefanini.model.enums.TipoDocumento;
@Slf4j
@Getter
@NoArgsConstructor
@Entity
@Table(name = "personas")
public class Persona {
    @Id
    private long id;
    @Enumerated(EnumType.STRING)
    private TipoDocumento tipoDocumento;
    private String primerNombre;
    private String segundoNombre;
    private String primerApellido;
    private String segundoApellido;
    private long telefono;
    private String direccion;
    private String ciudadResidencia;

    public Persona(long id, TipoDocumento tipoDocumento, String primerNombre, String segundoNombre, String primerApellido, String segundoApellido, long telefono, String direccion, String ciudadResidencia) {
        if (id < 1) {
            log.error("Id no puede ser Negativo");
            throw new IllegalArgumentException("Id no puede ser Negativo");
        }
        if(telefono < 1000000000L || telefono > 9999999999L) {
            log.error("Teléfono no es valido");
            throw new IllegalArgumentException("Teléfono no es valido");
        }
        this.id = id;
        this.tipoDocumento = tipoDocumento;
        this.primerNombre = primerNombre;
        this.segundoNombre = segundoNombre;
        this.primerApellido = primerApellido;
        this.segundoApellido = segundoApellido;
        this.telefono = telefono;
        this.direccion = direccion;
        this.ciudadResidencia = ciudadResidencia;
    }
}
