package com.ucompensar.platostipicosapi.dao;

import com.ucompensar.platostipicosapi.model.Ingrediente;
import jakarta.persistence.EntityManager;

public class IngredienteDao extends GenericDao<Ingrediente, Long> {

    public IngredienteDao(EntityManager em, Class<Ingrediente> entityClass) {
        super(em, entityClass);
    }
}
