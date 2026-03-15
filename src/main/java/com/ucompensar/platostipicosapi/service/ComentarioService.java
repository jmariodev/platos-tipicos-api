package com.ucompensar.platostipicosapi.service;

import com.ucompensar.platostipicosapi.dao.ComentarioDao;
import com.ucompensar.platostipicosapi.model.Comentario;
import com.ucompensar.platostipicosapi.util.JPAUtil;
import jakarta.persistence.EntityManager;

import java.util.List;

public class ComentarioService {

    public ComentarioService(){}

    public List<Comentario> findAll() {
        try(EntityManager em = JPAUtil.getEntityManager()) {
            ComentarioDao comentarioDao = new ComentarioDao(em, Comentario.class);
            return comentarioDao.findAll();
        }
    }

    public Comentario findById(Long id) {
        try(EntityManager em = JPAUtil.getEntityManager()){
            ComentarioDao comentarioDao = new ComentarioDao(em, Comentario.class);
            return comentarioDao.findById(id);
        }
    }

    public void create(Comentario comentario) {
        try(EntityManager em = JPAUtil.getEntityManager()){
            ComentarioDao comentarioDao = new ComentarioDao(em, Comentario.class);
            comentarioDao.create(comentario);
        }
    }

    public Comentario update(Comentario comentario) {
        try(EntityManager em = JPAUtil.getEntityManager()) {
            ComentarioDao comentarioDao = new ComentarioDao(em, Comentario.class);
            return comentarioDao.update(comentario);
        }
    }

    public void delete(Long id) {
        try(EntityManager em = JPAUtil.getEntityManager()) {
            ComentarioDao comentarioDao = new ComentarioDao(em, Comentario.class);
            comentarioDao.delete(id);
        }
    }
}
