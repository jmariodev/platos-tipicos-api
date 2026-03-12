package com.ucompensar.platostipicosapi.dao;

import com.ucompensar.platostipicosapi.model.Rol;
import jakarta.persistence.EntityManager;

public class RolDao extends GenericDao<Rol, Long>{
    public RolDao(EntityManager em, Class<Rol> entityClass) {
        super(em, entityClass);
    }
}
