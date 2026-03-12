package com.ucompensar.platostipicosapi.service;

import com.ucompensar.platostipicosapi.dao.RolDao;
import com.ucompensar.platostipicosapi.model.Rol;
import com.ucompensar.platostipicosapi.util.JPAUtil;
import jakarta.persistence.EntityManager;

import java.util.List;

public class RolService{
    public RolService() {}

    public List<Rol> findAll() {
        try (EntityManager em = JPAUtil.getEntityManager()) {
            RolDao rolDao = new RolDao(em, Rol.class);
            return rolDao.findAll();
        }
    }

    public Rol findById(Long id) {
        try (EntityManager em = JPAUtil.getEntityManager()) {
            RolDao rolDao = new RolDao(em, Rol.class);
            return rolDao.findById(id);
        }
    }

    public void create(Rol rol) {
        try (EntityManager em = JPAUtil.getEntityManager()) {
            RolDao rolDao = new RolDao(em, Rol.class);
            rolDao.create(rol);
        }
    }

    public Rol update(Rol rol) {
        try (EntityManager em = JPAUtil.getEntityManager()) {
            RolDao rolDao = new RolDao(em, Rol.class);
            return rolDao.update(rol);
        }
    }

    public void delete(Long id) {
        try (EntityManager em = JPAUtil.getEntityManager()) {
            RolDao rolDao = new RolDao(em, Rol.class);
            rolDao.delete(id);
        }
    }

}
