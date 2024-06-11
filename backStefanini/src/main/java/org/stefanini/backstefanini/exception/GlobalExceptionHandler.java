package org.stefanini.backstefanini.exception;

import lombok.extern.slf4j.Slf4j;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.MethodArgumentNotValidException;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.stefanini.backstefanini.exception.model.PersonaNotFoundResponse;
import org.stefanini.backstefanini.exception.model.ValidacionArgumentosResponse;
import org.stefanini.backstefanini.exception.model.CampoError;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

@Slf4j
@ControllerAdvice
public class GlobalExceptionHandler {

    @ExceptionHandler(PersonaNotFoundException.class)
    public ResponseEntity<PersonaNotFoundResponse> handlerPersonaNotFoundException(PersonaNotFoundException ex) {
        log.warn("El usuario con la identificación {} y tipo de documento {} no existe", ex.getNumeroDocumento(), ex.getTipoDocumento());
        PersonaNotFoundResponse response = new PersonaNotFoundResponse("Persona no encontrada", ex.getTipoDocumento(), ex.getNumeroDocumento());
        return ResponseEntity.status(404).body(response);
    }

    @ExceptionHandler(MethodArgumentNotValidException.class)
    public ResponseEntity<ValidacionArgumentosResponse> handlerValidationArgumentException(MethodArgumentNotValidException ex) {
        log.warn("Los siguientes campo están erroneas en la petición: {}", ex.getFieldErrors());
        Map<String, String> errores = new HashMap<>();
        ex.getFieldErrors().forEach(error -> errores.put(error.getField(), error.getDefaultMessage()));
        List<CampoError> campoErrores = errores.entrySet().stream().map(entry -> new CampoError(entry.getKey(), entry.getValue())).toList();
        ValidacionArgumentosResponse response = new ValidacionArgumentosResponse("Argumentos incorrectos en la petición", campoErrores);
        return ResponseEntity.badRequest().body(response);
    }

    @ExceptionHandler(RuntimeException.class)
    public ResponseEntity<String> handlerException(Exception ex) {
        return ResponseEntity.status(500).body(ex.getMessage());
    }
}
