package com.ucompensar.platostipicosapi.controller;

import com.ucompensar.platostipicosapi.dto.PlatoDto;
import com.ucompensar.platostipicosapi.model.Plato;
import com.ucompensar.platostipicosapi.service.PlatoService;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;

import java.util.List;

@WebServlet("/api/plato/*")
public class PlatoController extends BaseServlet {
    private final PlatoService platoService = new PlatoService();

    @Override
    protected void list(HttpServletRequest req, HttpServletResponse resp) throws Exception {
        List<PlatoDto> platos = platoService.findAll();
        resp.setContentType("application/json");
        objectMapper.writeValue(resp.getWriter(), platos);
    }

    @Override
    protected void getById(HttpServletRequest req, HttpServletResponse resp, Long id) throws Exception {
        PlatoDto plato = platoService.findById(id);
        resp.setContentType("application/json");
        objectMapper.writeValue(resp.getWriter(), plato);
    }

    @Override
    protected void getByRegion(HttpServletRequest req, HttpServletResponse resp, Long regionId) throws Exception {
        List<PlatoDto> platos = platoService.finByRegion(regionId);
        resp.setContentType("application/json");
        objectMapper.writeValue(resp.getWriter(), platos);
    }

    @Override
    protected void create(HttpServletRequest req, HttpServletResponse resp) throws Exception {
        Plato plato = objectMapper.readValue(req.getInputStream(), Plato.class);
        platoService.create(plato);
        resp.setStatus(HttpServletResponse.SC_OK);
        objectMapper.writeValue(resp.getWriter(), plato);
    }

    @Override
    protected void update(HttpServletRequest req, HttpServletResponse resp) throws Exception {
        Plato plato = objectMapper.readValue(req.getInputStream(), Plato.class);
        Plato updated = platoService.update(plato);

        resp.setStatus(HttpServletResponse.SC_OK);
        objectMapper.writeValue(resp.getWriter(), updated);
    }

    @Override
    protected void delete(HttpServletRequest req, HttpServletResponse resp, Long id) {
        platoService.delete(id);
        resp.setStatus(HttpServletResponse.SC_NO_CONTENT);
    }
}
