package com.ucompensar.platostipicosapi.controller;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.ucompensar.platostipicosapi.daoImp.RegionDaoImp;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;

import java.io.IOException;

@WebServlet("/api/region")
public class RegionController extends BaseServlet {

    private final RegionDaoImp regionDaoImp = new RegionDaoImp();
    private final ObjectMapper objectMapper = new ObjectMapper();

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws IOException {
        try {
            resp.setContentType("application/json");
            objectMapper.writeValue(resp.getWriter(),regionDaoImp.listarTodos());
        } catch (Exception e) {
            manejarError(resp, e);
        }
    }
}
