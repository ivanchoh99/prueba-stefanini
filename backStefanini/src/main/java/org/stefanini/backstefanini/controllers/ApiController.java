package org.stefanini.backstefanini.controllers;

import jakarta.validation.Valid;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.*;
import org.stefanini.backstefanini.models.Persona;
import org.stefanini.backstefanini.models.dto.PersonaRequest;
import org.stefanini.backstefanini.models.dto.PersonaResponse;
import org.stefanini.backstefanini.models.enums.TipoDocumento;
import org.stefanini.backstefanini.services.IPersona;

@Slf4j
@RequestMapping("/api/stefanini")
@RestController
@RequiredArgsConstructor
@Validated
public class ApiController {

    private final IPersona personaService;

    @GetMapping("/persona")
    public ResponseEntity<PersonaResponse> getPersona(@Valid @ModelAttribute PersonaRequest datosPersona ) {
        TipoDocumento tipoDocumento = TipoDocumento.getTipoDocumento(datosPersona.tipoDocumento());
        Persona persona = personaService.getPersona(tipoDocumento, datosPersona.numeroDocumento());
//        Persona persona = personaService.getPersona(TipoDocumento.C,23445322);
        log.info("Usuario {} obtenido", datosPersona.numeroDocumento());
        PersonaResponse response = new PersonaResponse(persona);
        return ResponseEntity.status(200).body(response);
    }

    @GetMapping("/healt")
    public ResponseEntity<String> healt() {
        log.info("Estado de la aplicación: Ejecutando y arrancada correctamente");
        return ResponseEntity.ok("El servicio esta funcionando");
    }
}

