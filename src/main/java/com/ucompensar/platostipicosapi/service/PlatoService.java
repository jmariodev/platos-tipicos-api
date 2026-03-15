package com.ucompensar.platostipicosapi.service;

import com.ucompensar.platostipicosapi.dao.PlatoDao;
import com.ucompensar.platostipicosapi.dto.PlatoDto;
import com.ucompensar.platostipicosapi.model.Plato;
import com.ucompensar.platostipicosapi.util.JPAUtil;
import jakarta.persistence.EntityManager;

import java.util.List;

public class PlatoService {

    public PlatoService(){}

    public List<PlatoDto> findAll() {
        try(EntityManager em = JPAUtil.getEntityManager()) {
            PlatoDao platoDao = new PlatoDao(em, Plato.class);
            return platoDao.findAll().stream().map(PlatoDto::toDto).toList();
        }
    }

    public PlatoDto findById(Long id) {
        try(EntityManager em = JPAUtil.getEntityManager()){
            PlatoDao platoDao = new PlatoDao(em, Plato.class);
            new PlatoDto();
            return PlatoDto.toDto(platoDao.findById(id));
        }
    }

    public List<PlatoDto> finByRegion(Long regionId) throws  Exception{
        try(EntityManager em = JPAUtil.getEntityManager()){
            PlatoDao platoDao = new PlatoDao(em, Plato.class);
            return platoDao.finByRegion(regionId);
        }
    }

    public PlatoDto create(Plato plato) {
        plato.setId(null);

        if (plato.getGaleria() != null) {
            plato.getGaleria().forEach(g -> g.setPlato(plato));
        }

        try(EntityManager em = JPAUtil.getEntityManager()){
            PlatoDao platoDao = new PlatoDao(em, Plato.class);
            return PlatoDto.toDto(platoDao.create(plato));
        }
    }

    public PlatoDto update(Plato plato) {
        if (plato.getGaleria() != null) {
            plato.getGaleria().forEach(g -> g.setPlato(plato));
        }

        try(EntityManager em = JPAUtil.getEntityManager()) {
            PlatoDao platoDao = new PlatoDao(em, Plato.class);
            return PlatoDto.toDto(platoDao.update(plato));
        }
    }

    public void delete(Long id) {
        try(EntityManager em = JPAUtil.getEntityManager()) {
            PlatoDao platoDao = new PlatoDao(em, Plato.class);
            platoDao.delete(id);
        }
    }
}
