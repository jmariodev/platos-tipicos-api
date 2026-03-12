package com.ucompensar.platostipicosapi.controller;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.ucompensar.platostipicosapi.util.ErrorResponse;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;

import java.io.IOException;

public abstract class BaseServlet extends HttpServlet {

    protected ObjectMapper objectMapper = new ObjectMapper();

    protected void manageError(HttpServletResponse resp, Exception e) throws IOException {

        resp.setContentType("application/json");

        ErrorResponse error = new ErrorResponse(
                "Error en la solicitud",
                e.getMessage()
        );

        resp.setStatus(HttpServletResponse.SC_INTERNAL_SERVER_ERROR);

        objectMapper.writeValue(resp.getWriter(), error);
    }

    protected Long getId(HttpServletRequest req) {

        String pathInfo = req.getPathInfo();

        if (pathInfo == null || pathInfo.equals("/")) {
            return null;
        }

        return Long.parseLong(pathInfo.substring(1));
    }

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws IOException {

        try {

            Long id = getId(req);

            if (id == null) {
                list(req, resp);
            } else {
                getById(req, resp, id);
            }

        } catch (Exception e) {
            manageError(resp, e);
        }
    }

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws IOException {

        try {
            create(req, resp);
        } catch (Exception e) {
            manageError(resp, e);
        }
    }

    @Override
    protected void doPut(HttpServletRequest req, HttpServletResponse resp) throws IOException {

        try {

            update(req, resp);

        } catch (Exception e) {
            manageError(resp, e);
        }
    }

    @Override
    protected void doDelete(HttpServletRequest req, HttpServletResponse resp) throws IOException {

        try {

            Long id = getId(req);

            if (id == null) {
                resp.setStatus(HttpServletResponse.SC_BAD_REQUEST);
                return;
            }

            delete(req, resp, id);

        } catch (Exception e) {
            manageError(resp, e);
        }
    }

    protected void list(HttpServletRequest req, HttpServletResponse resp) throws Exception {}

    protected void getById(HttpServletRequest req, HttpServletResponse resp, Long id) throws Exception {}

    protected void create(HttpServletRequest req, HttpServletResponse resp) throws Exception {}

    protected void update(HttpServletRequest req, HttpServletResponse resp) throws Exception {}

    protected void delete(HttpServletRequest req, HttpServletResponse resp, Long id) {}


}
