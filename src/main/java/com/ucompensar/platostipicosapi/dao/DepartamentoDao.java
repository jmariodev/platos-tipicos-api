package com.ucompensar.platostipicosapi.dao;

import com.ucompensar.platostipicosapi.dto.DepartamentoDto;
import com.ucompensar.platostipicosapi.model.Departamento;
import jakarta.persistence.EntityManager;

import java.util.List;

public class DepartamentoDao extends GenericDao<Departamento, Long> {

    public DepartamentoDao(EntityManager em, Class<Departamento> entityClass) {
        super(em, entityClass);
    }

    public List<DepartamentoDto> finByRegion(Long regionId) {

        return em.createQuery("SELECT d.id, d.nombre, d.region.id as regionId FROM Departamento d WHERE d.region.id = :regionId", DepartamentoDto.class)
                .setParameter("regionId", regionId)
                .getResultList();
    }
}
