package com.ucompensar.platostipicosapi.service;

import com.ucompensar.platostipicosapi.dao.UsuarioDao;
import com.ucompensar.platostipicosapi.model.Usuario;
import com.ucompensar.platostipicosapi.util.JPAUtil;
import jakarta.persistence.EntityManager;

import java.util.List;

public class UsuarioService {

    public UsuarioService(){}

    public List<Usuario> findAll() {
        try(EntityManager em = JPAUtil.getEntityManager()) {
            UsuarioDao usuarioDao = new UsuarioDao(em, Usuario.class);
            return usuarioDao.findAll();
        }
    }

    public Usuario findById(Long id) {
        try(EntityManager em = JPAUtil.getEntityManager()){
            UsuarioDao usuarioDao = new UsuarioDao(em, Usuario.class);
            return usuarioDao.findById(id);
        }
    }

    public void create(Usuario usuario) {
        try(EntityManager em = JPAUtil.getEntityManager()){
            UsuarioDao usuarioDao = new UsuarioDao(em, Usuario.class);
            usuarioDao.create(usuario);
        }
    }

    public Usuario update(Usuario usuario) {
        try(EntityManager em = JPAUtil.getEntityManager()) {
            UsuarioDao usuarioDao = new UsuarioDao(em, Usuario.class);
            return usuarioDao.update(usuario);
        }
    }

    public void delete(Long id) {
        try(EntityManager em = JPAUtil.getEntityManager()) {
            UsuarioDao usuarioDao = new UsuarioDao(em, Usuario.class);
            usuarioDao.delete(id);
        }
    }
}
