package com.ucompensar.platostipicosapi.controller;

import com.ucompensar.platostipicosapi.model.Rol;
import com.ucompensar.platostipicosapi.service.RolService;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;

import java.util.List;

@WebServlet("/api/rol/*")
public class RolController extends BaseServlet{
    
    private final RolService rolService = new RolService();

    @Override
    protected void list(HttpServletRequest req, HttpServletResponse resp) throws Exception {

        List<Rol> roles = rolService.findAll();

        resp.setContentType("application/json");

        objectMapper.writeValue(resp.getWriter(), roles);
    }

    @Override
    protected void getById(HttpServletRequest req, HttpServletResponse resp, Long id) throws Exception {

        Rol rol = rolService.findById(id);

        resp.setContentType("application/json");

        objectMapper.writeValue(resp.getWriter(), rol);
    }

    @Override
    protected void create(HttpServletRequest req, HttpServletResponse resp) throws Exception {

        Rol rol = objectMapper.readValue(req.getInputStream(), Rol.class);

        rolService.create(rol);

        resp.setStatus(HttpServletResponse.SC_CREATED);

        objectMapper.writeValue(resp.getWriter(), rol);
    }

    @Override
    protected void update(HttpServletRequest req, HttpServletResponse resp) throws Exception {

        Rol rol = objectMapper.readValue(req.getInputStream(), Rol.class);

        Rol updated = rolService.update(rol);

        objectMapper.writeValue(resp.getWriter(), updated);
    }

    @Override
    protected void delete(HttpServletRequest req, HttpServletResponse resp, Long id) {

        rolService.delete(id);

        resp.setStatus(HttpServletResponse.SC_NO_CONTENT);
    }
}
