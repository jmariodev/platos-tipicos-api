/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.ucompensar.platostipicosapi.service;


import com.ucompensar.platostipicosapi.dao.UsuarioDao;
import com.ucompensar.platostipicosapi.dto.UsuarioDto;
import com.ucompensar.platostipicosapi.model.Rol;
import com.ucompensar.platostipicosapi.model.Usuario;
import com.ucompensar.platostipicosapi.util.JPAUtil;
import com.ucompensar.platostipicosapi.util.PasswordUtil;
import jakarta.persistence.EntityManager;

import java.util.List;

public class AuthService {

    public UsuarioDto login(String username, String passwordPlano) {

        if (username == null || passwordPlano == null) return null;

        try(EntityManager em = JPAUtil.getEntityManager();) {
            UsuarioDao dao = new UsuarioDao(em, Usuario.class);
            Usuario usuario = dao.findByUser(username);

            if (usuario == null) return null;
            if (!usuario.isEstado()) return null;
            System.out.println(PasswordUtil.cifrar(passwordPlano));
            if (!PasswordUtil.verificar(passwordPlano, usuario.getContrasena())) {
                return null;
            }

            List<Rol> roles = usuario.getRoles();
            usuario.setRoles(roles);


            return UsuarioDto.toDto(usuario);

        }
    }
}

