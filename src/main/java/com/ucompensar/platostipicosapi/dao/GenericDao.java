package com.ucompensar.platostipicosapi.dao;

import jakarta.persistence.EntityManager;

import java.util.List;
import java.util.function.Supplier;

public abstract class GenericDao<T, ID> {

    protected EntityManager em;
    private final Class<T> entityClass;

    protected GenericDao(EntityManager em, Class<T> entityClass) {
        this.em = em;
        this.entityClass = entityClass;
    }

    public void create(T entity) {
        executeInsideTransaction(() -> {
            em.persist(entity);
            return entity;
        });
    }

    public T findById(ID id) {
        return em.find(entityClass, id);
    }

    public List<T> findAll() {
        String query = "SELECT e FROM " + entityClass.getName() + " e";
        return em.createQuery(query, entityClass).getResultList();
    }

    public T update(T entity) {

        return executeInsideTransaction(() -> em.merge(entity));
    }

    public void delete(Long id) {
        executeInsideTransaction(() -> {
            T entity = em.find(entityClass, id);
            if (entity != null) {
                em.remove(entity);
            }
            return entity;
        });
    }

    private <R> R executeInsideTransaction(Supplier<R> action) {

        try {

            em.getTransaction().begin();

            R result = action.get();

            em.getTransaction().commit();

            return result;

        } catch (RuntimeException e) {

            em.getTransaction().rollback();

            throw e;
        }
    }
}