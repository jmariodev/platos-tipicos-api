package com.ucompensar.platostipicosapi.dao;

import com.ucompensar.platostipicosapi.dto.PlatoDto;
import com.ucompensar.platostipicosapi.model.Plato;
import jakarta.persistence.EntityManager;

import java.util.List;

public class PlatoDao extends GenericDao<Plato, Long> {

    public PlatoDao(EntityManager em, Class<Plato> entityClass) {
        super(em, entityClass);
    }

    public List<PlatoDto> finByRegion(Long regionId) {

        return em.createQuery("SELECT p FROM Plato p WHERE p.departamento.region.id = :regionId", Plato.class)
                .setParameter("regionId", regionId)
                .getResultList()
                .stream()
                .map(PlatoDto::toDto)
                .toList();
    }
}
