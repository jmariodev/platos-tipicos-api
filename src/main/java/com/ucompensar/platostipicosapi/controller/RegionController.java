package com.ucompensar.platostipicosapi.controller;

import com.ucompensar.platostipicosapi.dto.RegionDto;
import com.ucompensar.platostipicosapi.service.RegionService;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;

import java.util.List;

@WebServlet("/api/region")
public class RegionController extends BaseServlet {

    private final RegionService regionService = new RegionService();

    @Override
    protected void list(HttpServletRequest req, HttpServletResponse resp) throws Exception {

        List<RegionDto> regiones = regionService.findAll();

        resp.setContentType("application/json");

        objectMapper.writeValue(resp.getWriter(), regiones);
    }
}
