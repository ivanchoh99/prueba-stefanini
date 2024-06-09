package org.stefanini.backstefanini.exceptions.models;

import org.stefanini.backstefanini.models.CampoError;

import java.util.List;

public record ValidacionArgumentosResponse(
        String mensaje,
        List<CampoError> campoErrors
) {
}
