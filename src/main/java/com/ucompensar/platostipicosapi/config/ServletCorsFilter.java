package com.ucompensar.platostipicosapi.config;

import jakarta.servlet.*;
import jakarta.servlet.annotation.WebFilter;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;

import java.io.IOException;

@WebFilter("/*")
public class ServletCorsFilter implements Filter {

    @Override
    public void doFilter(ServletRequest request, ServletResponse response, FilterChain chain)
            throws IOException, ServletException {

        HttpServletResponse httpResponse = (HttpServletResponse) response;
        HttpServletRequest httpRequest = (HttpServletRequest) request;

        // Permite solicitudes desde cualquier origen. Para producción, es mejor restringirlo.
        httpResponse.setHeader("Access-Control-Allow-Origin", "*");

        // Cabeceras permitidas
        httpResponse.setHeader("Access-Control-Allow-Headers", "origin, content-type, accept, authorization");

        // Permitir credenciales (cookies, etc.)
        httpResponse.setHeader("Access-Control-Allow-Credentials", "true");

        // Métodos HTTP permitidos
        httpResponse.setHeader("Access-Control-Allow-Methods", "GET, POST, PUT, DELETE, OPTIONS, HEAD");

        // El navegador envía una solicitud OPTIONS (preflight) antes de POST, PUT, DELETE.
        // Debemos responder con OK a estas solicitudes para que el navegador proceda.
        if ("OPTIONS".equalsIgnoreCase(httpRequest.getMethod())) {
            httpResponse.setStatus(HttpServletResponse.SC_OK);
        } else {
            chain.doFilter(request, response);
        }
    }
}
