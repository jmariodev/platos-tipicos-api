package com.ucompensar.platostipicosapi.service;

import com.ucompensar.platostipicosapi.dao.RegionDao;
import com.ucompensar.platostipicosapi.dto.RegionDto;
import com.ucompensar.platostipicosapi.model.Region;
import com.ucompensar.platostipicosapi.util.JPAUtil;
import jakarta.persistence.EntityManager;

import java.util.List;

public class RegionService {
    public List<RegionDto> findAll() {
        try (EntityManager em = JPAUtil.getEntityManager()) {
            return new RegionDao(em, Region.class).findAll()
                    .stream()
                    .map(RegionDto::toDto)
                    .toList();
        }
    }
}
