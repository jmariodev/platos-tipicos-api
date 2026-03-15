/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.ucompensar.platostipicosapi.controller;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.ucompensar.platostipicosapi.dto.LoginRequestDTO;
import com.ucompensar.platostipicosapi.dto.UsuarioDto;
import com.ucompensar.platostipicosapi.service.AuthService;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import jakarta.servlet.http.HttpSession;

import java.io.IOException;

@WebServlet("/api/login")
public class AuthController extends HttpServlet {

    private final AuthService authService = new AuthService();
    private final ObjectMapper mapper = new ObjectMapper();

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws IOException {

        LoginRequestDTO login = mapper.readValue(req.getInputStream(), LoginRequestDTO.class);

        UsuarioDto usuarioDto = authService.login(login.getUsuario(), login.getContrasena());

        if (usuarioDto == null) {
            resp.setStatus(HttpServletResponse.SC_UNAUTHORIZED);
            resp.getWriter().write("Credenciales inválidas");
            return;
        }

        HttpSession session = req.getSession(true);
        session.setAttribute("usuario", usuarioDto);

        resp.setContentType("application/json");
        resp.setCharacterEncoding("UTF-8");
        mapper.writeValue(resp.getWriter(), usuarioDto);
    }
}
