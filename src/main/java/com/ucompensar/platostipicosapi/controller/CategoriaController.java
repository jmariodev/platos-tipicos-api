package com.ucompensar.platostipicosapi.controller;

import com.ucompensar.platostipicosapi.model.Categoria;
import com.ucompensar.platostipicosapi.service.CategoriaService;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;

import java.util.List;

@WebServlet("/api/categoria/*")
public class CategoriaController extends BaseServlet{
    private final CategoriaService categoriaService = new CategoriaService();

    @Override
    protected void list(HttpServletRequest req, HttpServletResponse resp) throws Exception {

        List<Categoria> categorias = categoriaService.findAll();

        resp.setContentType("application/json");

        objectMapper.writeValue(resp.getWriter(), categorias);
    }

    @Override
    protected void getById(HttpServletRequest req, HttpServletResponse resp, Long id) throws Exception {

        Categoria categoria = categoriaService.findById(id);

        resp.setContentType("application/json");

        objectMapper.writeValue(resp.getWriter(), categoria);
    }

    @Override
    protected void create(HttpServletRequest req, HttpServletResponse resp) throws Exception {

        Categoria categoria = objectMapper.readValue(req.getInputStream(), Categoria.class);

        categoriaService.create(categoria);

        resp.setStatus(HttpServletResponse.SC_CREATED);

        objectMapper.writeValue(resp.getWriter(), categoria);
    }

    @Override
    protected void update(HttpServletRequest req, HttpServletResponse resp) throws Exception {

        Categoria categoria = objectMapper.readValue(req.getInputStream(), Categoria.class);

        Categoria updated = categoriaService.update(categoria);

        objectMapper.writeValue(resp.getWriter(), updated);
    }

    @Override
    protected void delete(HttpServletRequest req, HttpServletResponse resp, Long id) {

        categoriaService.delete(id);

        resp.setStatus(HttpServletResponse.SC_NO_CONTENT);
    }
}
