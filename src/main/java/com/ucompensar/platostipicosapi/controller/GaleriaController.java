package com.ucompensar.platostipicosapi.controller;

import com.ucompensar.platostipicosapi.model.Galeria;
import com.ucompensar.platostipicosapi.service.GaleriaService;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;

import java.util.List;

@WebServlet("/api/galeria/*")
public class GaleriaController extends BaseServlet {
    private final GaleriaService galeriaService = new GaleriaService();

    @Override
    protected void list(HttpServletRequest req, HttpServletResponse resp) throws Exception {
        List<Galeria> galerias = galeriaService.findAll();
        resp.setContentType("application/json");
        objectMapper.writeValue(resp.getWriter(), galerias);
    }

    @Override
    protected void getById(HttpServletRequest req, HttpServletResponse resp, Long id) throws Exception {
        Galeria galeria = galeriaService.findById(id);
        resp.setContentType("application/json");
        objectMapper.writeValue(resp.getWriter(), galeria);
    }

    @Override
    protected void create(HttpServletRequest req, HttpServletResponse resp) throws Exception {
        Galeria galeria = objectMapper.readValue(req.getInputStream(), Galeria.class);
        galeriaService.create(galeria);
        resp.setStatus(HttpServletResponse.SC_CREATED);
        objectMapper.writeValue(resp.getWriter(), galeria);
    }

    @Override
    protected void update(HttpServletRequest req, HttpServletResponse resp) throws Exception {
        Galeria galeria = objectMapper.readValue(req.getInputStream(), Galeria.class);
        Galeria updated = galeriaService.update(galeria);
        objectMapper.writeValue(resp.getWriter(), updated);
    }

    @Override
    protected void delete(HttpServletRequest req, HttpServletResponse resp, Long id) {
        galeriaService.delete(id);
        resp.setStatus(HttpServletResponse.SC_NO_CONTENT);
    }
}
