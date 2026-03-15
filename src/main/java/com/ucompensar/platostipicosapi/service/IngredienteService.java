package com.ucompensar.platostipicosapi.service;

import com.ucompensar.platostipicosapi.dao.IngredienteDao;
import com.ucompensar.platostipicosapi.model.Ingrediente;
import com.ucompensar.platostipicosapi.util.JPAUtil;
import jakarta.persistence.EntityManager;

import java.util.List;

public class IngredienteService {

    public IngredienteService(){}

    public List<Ingrediente> findAll() {
        try(EntityManager em = JPAUtil.getEntityManager()) {
            IngredienteDao ingredienteDao = new IngredienteDao(em, Ingrediente.class);
            return ingredienteDao.findAll();
        }
    }

    public Ingrediente findById(Long id) {
        try(EntityManager em = JPAUtil.getEntityManager()){
            IngredienteDao ingredienteDao = new IngredienteDao(em, Ingrediente.class);
            return ingredienteDao.findById(id);
        }
    }

    public void create(Ingrediente ingrediente) {
        try(EntityManager em = JPAUtil.getEntityManager()){
            IngredienteDao ingredienteDao = new IngredienteDao(em, Ingrediente.class);
            ingredienteDao.create(ingrediente);
        }
    }

    public Ingrediente update(Ingrediente ingrediente) {
        try(EntityManager em = JPAUtil.getEntityManager()) {
            IngredienteDao ingredienteDao = new IngredienteDao(em, Ingrediente.class);
            return ingredienteDao.update(ingrediente);
        }
    }

    public void delete(Long id) {
        try(EntityManager em = JPAUtil.getEntityManager()) {
            IngredienteDao ingredienteDao = new IngredienteDao(em, Ingrediente.class);
            ingredienteDao.delete(id);
        }
    }
}
