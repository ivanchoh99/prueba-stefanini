package org.stefanini.backstefanini;

import org.springframework.stereotype.Component;
import org.springframework.validation.BindException;
import org.springframework.validation.BindingResult;
import org.springframework.validation.FieldError;
import org.springframework.web.bind.MethodArgumentNotValidException;
import org.stefanini.backstefanini.model.enums.TipoDocumento;

@Component
public class Util {

    public TipoDocumento validateTipoDocumento(String tipoDocumento) throws MethodArgumentNotValidException {
        BindingResult bindingResult = new BindException(this,"Validation");
        bindingResult.addError(new FieldError("TipoDocumento","tipoDocumento","El tipo de documento no es valido"));
        if (tipoDocumento.equals("C") || tipoDocumento.equals("P")) {
            return TipoDocumento.valueOf(tipoDocumento);
        }
        throw new MethodArgumentNotValidException(null, bindingResult);
    }
}
