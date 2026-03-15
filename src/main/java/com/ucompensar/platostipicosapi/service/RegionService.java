package com.ucompensar.platostipicosapi.service;

import com.ucompensar.platostipicosapi.dao.RegionDao;
import com.ucompensar.platostipicosapi.model.Region;
import com.ucompensar.platostipicosapi.util.JPAUtil;
import jakarta.persistence.EntityManager;

import java.util.List;

public class RegionService {

    public RegionService(){}

    public List<Region> findAll() {
        try(EntityManager em = JPAUtil.getEntityManager()) {
            RegionDao regionDao = new RegionDao(em, Region.class);
            return regionDao.findAll();
        }
    }

    public Region findById(Long id) {
        try(EntityManager em = JPAUtil.getEntityManager()){
            RegionDao regionDao = new RegionDao(em, Region.class);
            return regionDao.findById(id);
        }
    }

    public void create(Region region) {
        try(EntityManager em = JPAUtil.getEntityManager()){
            RegionDao regionDao = new RegionDao(em, Region.class);
            regionDao.create(region);
        }
    }

    public Region update(Region region) {
        try(EntityManager em = JPAUtil.getEntityManager()) {
            RegionDao regionDao = new RegionDao(em, Region.class);
            return regionDao.update(region);
        }
    }

    public void delete(Long id) {
        try(EntityManager em = JPAUtil.getEntityManager()) {
            RegionDao regionDao = new RegionDao(em, Region.class);
            regionDao.delete(id);
        }
    }
}
