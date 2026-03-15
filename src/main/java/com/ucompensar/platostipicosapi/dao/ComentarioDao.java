package com.ucompensar.platostipicosapi.dao;

import com.ucompensar.platostipicosapi.model.Comentario;
import jakarta.persistence.EntityManager;

public class ComentarioDao extends GenericDao<Comentario, Long> {

    public ComentarioDao(EntityManager em, Class<Comentario> entityClass) {
        super(em, entityClass);
    }
}
