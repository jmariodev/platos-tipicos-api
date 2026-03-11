package com.ucompensar.platostipicosapi.dao;

import com.ucompensar.platostipicosapi.model.Region;
import jakarta.persistence.EntityManager;

public class RegionDao extends GenericDAO<Region, Long>{
    public RegionDao(EntityManager em, Class<Region> entityClass) {
        super(em, entityClass);
    }
}
