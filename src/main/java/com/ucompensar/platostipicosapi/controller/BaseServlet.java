package com.ucompensar.platostipicosapi.controller;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.ucompensar.platostipicosapi.util.ErrorResponse;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletResponse;

import java.io.IOException;

public abstract class BaseServlet extends HttpServlet {

    protected ObjectMapper objectMapper = new ObjectMapper();

    protected void manejarError(HttpServletResponse resp, Exception e) throws IOException {

        resp.setContentType("application/json");

        ErrorResponse error = new ErrorResponse(
                "Error en la solicitud",
                e.getMessage()
        );

        resp.setStatus(HttpServletResponse.SC_INTERNAL_SERVER_ERROR);

        objectMapper.writeValue(resp.getWriter(), error);
    }

}
