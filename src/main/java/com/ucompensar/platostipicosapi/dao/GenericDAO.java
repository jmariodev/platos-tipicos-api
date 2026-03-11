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

    public void create(T entity) {
        try {
            em.getTransaction().begin();
            em.persist(entity);
            em.getTransaction().commit();
        } catch (Exception e) {
            if (em.getTransaction().isActive()) {
                em.getTransaction().rollback();
            }
            throw new RuntimeException("Error creando entidad", e);
        }
    }

    public T findById(ID id) {
        return em.find(entityClass, id);
    }

    public List<T> findAll() {
        return em.createQuery(
                "SELECT e FROM " + entityClass.getSimpleName() + " e",
                entityClass
        ).getResultList();
    }

    public T update(T entity) {
        try {
            em.getTransaction().begin();
            T entityUpdated = em.merge(entity);
            em.getTransaction().commit();
            return entityUpdated;
        } catch (Exception e) {
            if (em.getTransaction().isActive()) {
                em.getTransaction().rollback();
            }
            throw new RuntimeException("Error actualizando entidad", e);
        }
    }

    public void delete(ID id) {
        try {
            em.getTransaction().begin();
            T entity = em.find(entityClass, id);

            if (entity != null) {
                em.remove(entity);
            }
            em.getTransaction().commit();

        } catch (Exception e) {

            if (em.getTransaction().isActive()) {
                em.getTransaction().rollback();
            }

            throw new RuntimeException("Error eliminando entidad", e);
        }
    }
}