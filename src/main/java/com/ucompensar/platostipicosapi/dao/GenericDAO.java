package com.ucompensar.platostipicosapi.dao;

import jakarta.persistence.EntityManager;

import java.util.List;

public abstract class GenericDAO<T, ID> {

    protected EntityManager em;
    private final Class<T> entityClass;

    protected GenericDAO(EntityManager em, Class<T> entityClass) {
        this.em = em;
        this.entityClass = entityClass;
    }

    public void crear(T entidad) {
        em.getTransaction().begin();
        em.persist(entidad);
        em.getTransaction().commit();
    }

    public T buscarPorId(ID id) {
        return em.find(entityClass, id);
    }

    public List<T> listarTodos() {
        return em.createQuery(
                "SELECT e FROM " + entityClass.getSimpleName() + " e",
                entityClass
        ).getResultList();
    }

    public void actualizar(T entidad) {
        em.getTransaction().begin();
        em.merge(entidad);
        em.getTransaction().commit();
    }

    public void eliminar(ID id) {
        em.getTransaction().begin();
        T entidad = buscarPorId(id);
        if (entidad != null) {
            em.remove(entidad);
        }
        em.getTransaction().commit();
    }
}
