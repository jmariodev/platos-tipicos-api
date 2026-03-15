package com.ucompensar.platostipicosapi.dao;

import com.ucompensar.platostipicosapi.model.Usuario;
import jakarta.persistence.EntityManager;

public class UsuarioDao extends GenericDao<Usuario, Long> {

    public UsuarioDao(EntityManager em, Class<Usuario> entityClass) {
        super(em, entityClass);
    }

    public Usuario findByUser(String user) {
        return em.createQuery(
                        "SELECT u FROM Usuario u WHERE u.usuario = :user AND u.estado = true",
                        Usuario.class
                ).setParameter("user", user)
                .getResultStream()
                .findFirst()
                .orElse(null);
    }
}
