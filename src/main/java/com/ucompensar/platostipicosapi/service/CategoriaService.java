package com.ucompensar.platostipicosapi.service;

import com.ucompensar.platostipicosapi.dao.CategoriaDao;
import com.ucompensar.platostipicosapi.model.Categoria;
import com.ucompensar.platostipicosapi.util.JPAUtil;
import jakarta.persistence.EntityManager;

import java.util.List;

public class CategoriaService {

    public CategoriaService(){}

    public List<Categoria> findAll() {
        try(EntityManager em = JPAUtil.getEntityManager()) {
            CategoriaDao categoriaDao = new CategoriaDao(em, Categoria.class);
            return categoriaDao.findAll();
        }
    }

    public Categoria findById(Long id) {
        try(EntityManager em = JPAUtil.getEntityManager()){
            CategoriaDao categoriaDao = new CategoriaDao(em, Categoria.class);
            return categoriaDao.findById(id);
        }
    }

    public void create(Categoria categoria) {
        try(EntityManager em = JPAUtil.getEntityManager()){
            CategoriaDao categoriaDao = new CategoriaDao(em, Categoria.class);
            categoriaDao.create(categoria);
        }
    }

    public Categoria update(Categoria categoria) {
        try(EntityManager em = JPAUtil.getEntityManager()) {
            CategoriaDao categoriaDao = new CategoriaDao(em, Categoria.class);
            return categoriaDao.update(categoria);
        }
    }

    public void delete(Long id) {
        try(EntityManager em = JPAUtil.getEntityManager()) {
            CategoriaDao categoriaDao = new CategoriaDao(em, Categoria.class);
            categoriaDao.delete(id);
        }
    }
}
