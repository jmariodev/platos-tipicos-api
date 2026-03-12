package com.ucompensar.platostipicosapi.dao;

import com.ucompensar.platostipicosapi.model.Categoria;
import jakarta.persistence.EntityManager;

public class CategoriaDao extends GenericDao<Categoria, Long> {

    public CategoriaDao(EntityManager em, Class<Categoria> entityClass) {
        super(em, entityClass);
    }
}
