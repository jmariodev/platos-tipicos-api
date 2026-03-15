package com.ucompensar.platostipicosapi.dao;

import com.ucompensar.platostipicosapi.model.Galeria;
import jakarta.persistence.EntityManager;

public class GaleriaDao extends GenericDao<Galeria, Long> {

    public GaleriaDao(EntityManager em, Class<Galeria> entityClass) {
        super(em, entityClass);
    }
}
