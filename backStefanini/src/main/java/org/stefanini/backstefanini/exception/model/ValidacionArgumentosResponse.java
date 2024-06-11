package org.stefanini.backstefanini.exception.model;

import java.util.List;

public record ValidacionArgumentosResponse(
        String mensaje,
        List<CampoError> camposErroneos
) {
}
