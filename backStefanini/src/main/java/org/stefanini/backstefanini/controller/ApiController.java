package org.stefanini.backstefanini.controller;

import jakarta.validation.Valid;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.MethodArgumentNotValidException;
import org.springframework.web.bind.annotation.*;
import org.stefanini.backstefanini.model.PersonaRequest;
import org.stefanini.backstefanini.model.dto.PersonaDTO;
import org.stefanini.backstefanini.service.IPersona;

@Slf4j
@RequestMapping("/api/stefanini")
@RestController
@RequiredArgsConstructor
@Validated
public class ApiController {

    private final IPersona consultarPersonaService;

    @GetMapping("/persona")
    public ResponseEntity<PersonaDTO> getPersona(@Valid @ModelAttribute PersonaRequest request) throws MethodArgumentNotValidException {
        return ResponseEntity.ok(consultarPersonaService.getPersona(request));
    }

    @GetMapping("/healt")
    public ResponseEntity<String> healt() {
        log.info("Estado de la aplicación: Ejecutando");
        return ResponseEntity.ok("El servicio esta funcionando");
    }
}

