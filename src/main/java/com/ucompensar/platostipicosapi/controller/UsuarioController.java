package com.ucompensar.platostipicosapi.controller;

import com.ucompensar.platostipicosapi.model.Usuario;
import com.ucompensar.platostipicosapi.service.UsuarioService;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;

import java.util.List;

@WebServlet("/api/usuario/*")
public class UsuarioController extends BaseServlet {
    private final UsuarioService usuarioService = new UsuarioService();

    @Override
    protected void list(HttpServletRequest req, HttpServletResponse resp) throws Exception {
        List<Usuario> usuarios = usuarioService.findAll();
        resp.setContentType("application/json");
        objectMapper.writeValue(resp.getWriter(), usuarios);
    }

    @Override
    protected void getById(HttpServletRequest req, HttpServletResponse resp, Long id) throws Exception {
        Usuario usuario = usuarioService.findById(id);
        resp.setContentType("application/json");
        objectMapper.writeValue(resp.getWriter(), usuario);
    }

    @Override
    protected void create(HttpServletRequest req, HttpServletResponse resp) throws Exception {
        Usuario usuario = objectMapper.readValue(req.getInputStream(), Usuario.class);
        usuarioService.create(usuario);
        resp.setStatus(HttpServletResponse.SC_CREATED);
        objectMapper.writeValue(resp.getWriter(), usuario);
    }

    @Override
    protected void update(HttpServletRequest req, HttpServletResponse resp) throws Exception {
        Usuario usuario = objectMapper.readValue(req.getInputStream(), Usuario.class);
        Usuario updated = usuarioService.update(usuario);
        objectMapper.writeValue(resp.getWriter(), updated);
    }

    @Override
    protected void delete(HttpServletRequest req, HttpServletResponse resp, Long id) {
        usuarioService.delete(id);
        resp.setStatus(HttpServletResponse.SC_NO_CONTENT);
    }
}
