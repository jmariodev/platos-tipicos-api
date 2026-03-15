package com.ucompensar.platostipicosapi.service;

import com.ucompensar.platostipicosapi.dao.GaleriaDao;
import com.ucompensar.platostipicosapi.model.Galeria;
import com.ucompensar.platostipicosapi.util.JPAUtil;
import jakarta.persistence.EntityManager;

import java.util.List;

public class GaleriaService {

    public GaleriaService(){}

    public List<Galeria> findAll() {
        try(EntityManager em = JPAUtil.getEntityManager()) {
            GaleriaDao galeriaDao = new GaleriaDao(em, Galeria.class);
            return galeriaDao.findAll();
        }
    }

    public Galeria findById(Long id) {
        try(EntityManager em = JPAUtil.getEntityManager()){
            GaleriaDao galeriaDao = new GaleriaDao(em, Galeria.class);
            return galeriaDao.findById(id);
        }
    }

    public void create(Galeria galeria) {
        try(EntityManager em = JPAUtil.getEntityManager()){
            GaleriaDao galeriaDao = new GaleriaDao(em, Galeria.class);
            galeriaDao.create(galeria);
        }
    }

    public Galeria update(Galeria galeria) {
        try(EntityManager em = JPAUtil.getEntityManager()) {
            GaleriaDao galeriaDao = new GaleriaDao(em, Galeria.class);
            return galeriaDao.update(galeria);
        }
    }

    public void delete(Long id) {
        try(EntityManager em = JPAUtil.getEntityManager()) {
            GaleriaDao galeriaDao = new GaleriaDao(em, Galeria.class);
            galeriaDao.delete(id);
        }
    }
}
