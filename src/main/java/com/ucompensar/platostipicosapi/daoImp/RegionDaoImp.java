package com.ucompensar.platostipicosapi.daoImp;

import com.ucompensar.platostipicosapi.dao.RegionDao;
import com.ucompensar.platostipicosapi.model.Region;
import com.ucompensar.platostipicosapi.util.JPAUtil;
import jakarta.persistence.EntityManager;

import java.util.List;

public class RegionDaoImp{
    public List<Region> listarTodos() {
        try (EntityManager em = JPAUtil.getEntityManager()) {
            return new RegionDao(em, Region.class).findAll();
        }
    }
}
