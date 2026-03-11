package com.ucompensar.platostipicosapi.util;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
@AllArgsConstructor
public class ErrorResponse {

    private String mensaje;
    private String detalle;
}
