package com.ucompensar.platostipicosapi.controller;

import com.ucompensar.platostipicosapi.dto.ComentarioDto;
import com.ucompensar.platostipicosapi.model.Comentario;
import com.ucompensar.platostipicosapi.service.ComentarioService;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;

import java.util.List;

@WebServlet("/api/comentario/*")
public class ComentarioController extends BaseServlet {
    private final ComentarioService comentarioService = new ComentarioService();

    @Override
    protected void list(HttpServletRequest req, HttpServletResponse resp) throws Exception {
        List<Comentario> comentarios = comentarioService.findAll();
        resp.setContentType("application/json");
        objectMapper.writeValue(resp.getWriter(), comentarios);
    }

    @Override
    protected void getById(HttpServletRequest req, HttpServletResponse resp, Long id) throws Exception {
        Comentario comentario = comentarioService.findById(id);
        resp.setContentType("application/json");
        objectMapper.writeValue(resp.getWriter(), comentario);
    }

    @Override
    protected void create(HttpServletRequest req, HttpServletResponse resp) throws Exception {
        Comentario comentario = objectMapper.readValue(req.getInputStream(), Comentario.class);
        comentarioService.create(comentario);
        resp.setStatus(HttpServletResponse.SC_CREATED);
        objectMapper.writeValue(resp.getWriter(), ComentarioDto.toDto(comentario));
    }

    @Override
    protected void update(HttpServletRequest req, HttpServletResponse resp) throws Exception {
        Comentario comentario = objectMapper.readValue(req.getInputStream(), Comentario.class);
        Comentario updated = comentarioService.update(comentario);
        objectMapper.writeValue(resp.getWriter(), updated);
    }

    @Override
    protected void delete(HttpServletRequest req, HttpServletResponse resp, Long id) {
        comentarioService.delete(id);
        resp.setStatus(HttpServletResponse.SC_NO_CONTENT);
    }
}
