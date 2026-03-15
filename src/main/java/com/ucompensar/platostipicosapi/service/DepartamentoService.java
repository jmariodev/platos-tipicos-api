package com.ucompensar.platostipicosapi.service;

import com.ucompensar.platostipicosapi.dao.DepartamentoDao;
import com.ucompensar.platostipicosapi.dto.DepartamentoDto;
import com.ucompensar.platostipicosapi.model.Departamento;
import com.ucompensar.platostipicosapi.util.JPAUtil;
import jakarta.persistence.EntityManager;

import java.util.List;

public class DepartamentoService {

    public DepartamentoService(){}

    public List<Departamento> findAll() {
        try(EntityManager em = JPAUtil.getEntityManager()) {
            DepartamentoDao departamentoDao = new DepartamentoDao(em, Departamento.class);
            return departamentoDao.findAll();
        }
    }

    public Departamento findById(Long id) {
        try(EntityManager em = JPAUtil.getEntityManager()){
            DepartamentoDao departamentoDao = new DepartamentoDao(em, Departamento.class);
            return departamentoDao.findById(id);
        }
    }

    public List<DepartamentoDto> findByRegion(Long regionId){
        try(EntityManager em = JPAUtil.getEntityManager()){
            DepartamentoDao departamentoDao = new DepartamentoDao(em, Departamento.class);
            return departamentoDao.finByRegion(regionId);
        }
    }

    public void create(Departamento departamento) {
        try(EntityManager em = JPAUtil.getEntityManager()){
            DepartamentoDao departamentoDao = new DepartamentoDao(em, Departamento.class);
            departamentoDao.create(departamento);
        }
    }

    public Departamento update(Departamento departamento) {
        try(EntityManager em = JPAUtil.getEntityManager()) {
            DepartamentoDao departamentoDao = new DepartamentoDao(em, Departamento.class);
            return departamentoDao.update(departamento);
        }
    }

    public void delete(Long id) {
        try(EntityManager em = JPAUtil.getEntityManager()) {
            DepartamentoDao departamentoDao = new DepartamentoDao(em, Departamento.class);
            departamentoDao.delete(id);
        }
    }
}
