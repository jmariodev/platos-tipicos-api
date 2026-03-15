package com.ucompensar.platostipicosapi.controller;

import com.ucompensar.platostipicosapi.model.Ingrediente;
import com.ucompensar.platostipicosapi.service.IngredienteService;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;

import java.util.List;

@WebServlet("/api/ingrediente/*")
public class IngredienteController extends BaseServlet {
    private final IngredienteService ingredienteService = new IngredienteService();

    @Override
    protected void list(HttpServletRequest req, HttpServletResponse resp) throws Exception {
        List<Ingrediente> ingredientes = ingredienteService.findAll();
        resp.setContentType("application/json");
        objectMapper.writeValue(resp.getWriter(), ingredientes);
    }

    @Override
    protected void getById(HttpServletRequest req, HttpServletResponse resp, Long id) throws Exception {
        Ingrediente ingrediente = ingredienteService.findById(id);
        resp.setContentType("application/json");
        objectMapper.writeValue(resp.getWriter(), ingrediente);
    }

    @Override
    protected void create(HttpServletRequest req, HttpServletResponse resp) throws Exception {
        Ingrediente ingrediente = objectMapper.readValue(req.getInputStream(), Ingrediente.class);
        ingredienteService.create(ingrediente);
        resp.setStatus(HttpServletResponse.SC_CREATED);
        objectMapper.writeValue(resp.getWriter(), ingrediente);
    }

    @Override
    protected void update(HttpServletRequest req, HttpServletResponse resp) throws Exception {
        Ingrediente ingrediente = objectMapper.readValue(req.getInputStream(), Ingrediente.class);
        Ingrediente updated = ingredienteService.update(ingrediente);
        objectMapper.writeValue(resp.getWriter(), updated);
    }

    @Override
    protected void delete(HttpServletRequest req, HttpServletResponse resp, Long id) {
        ingredienteService.delete(id);
        resp.setStatus(HttpServletResponse.SC_NO_CONTENT);
    }
}
