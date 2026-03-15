package com.ucompensar.platostipicosapi.controller;

import com.ucompensar.platostipicosapi.dto.DepartamentoDto;
import com.ucompensar.platostipicosapi.model.Departamento;
import com.ucompensar.platostipicosapi.service.DepartamentoService;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;

import java.util.List;

@WebServlet("/api/departamento/*")
public class DepartamentoController extends BaseServlet {
    private final DepartamentoService departamentoService = new DepartamentoService();

    @Override
    protected void list(HttpServletRequest req, HttpServletResponse resp) throws Exception {
        List<Departamento> departamentos = departamentoService.findAll();
        resp.setContentType("application/json");
        objectMapper.writeValue(resp.getWriter(), departamentos);
    }

    @Override
    protected void getById(HttpServletRequest req, HttpServletResponse resp, Long id) throws Exception {
        Departamento departamento = departamentoService.findById(id);
        resp.setContentType("application/json");
        objectMapper.writeValue(resp.getWriter(), departamento);
    }

    @Override
    protected void getByRegion(HttpServletRequest req, HttpServletResponse resp, Long regionId) throws Exception {
        List<DepartamentoDto> departamentos = departamentoService.findByRegion(regionId);
        resp.setContentType("application/json");
        objectMapper.writeValue(resp.getWriter(), departamentos);
    }

    @Override
    protected void create(HttpServletRequest req, HttpServletResponse resp) throws Exception {
        Departamento departamento = objectMapper.readValue(req.getInputStream(), Departamento.class);
        departamentoService.create(departamento);
        resp.setStatus(HttpServletResponse.SC_CREATED);
        objectMapper.writeValue(resp.getWriter(), departamento);
    }

    @Override
    protected void update(HttpServletRequest req, HttpServletResponse resp) throws Exception {
        Departamento departamento = objectMapper.readValue(req.getInputStream(), Departamento.class);
        Departamento updated = departamentoService.update(departamento);
        objectMapper.writeValue(resp.getWriter(), updated);
    }

    @Override
    protected void delete(HttpServletRequest req, HttpServletResponse resp, Long id) {
        departamentoService.delete(id);
        resp.setStatus(HttpServletResponse.SC_NO_CONTENT);
    }
}
