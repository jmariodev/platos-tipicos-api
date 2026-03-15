package com.ucompensar.platostipicosapi.dto;

import com.ucompensar.platostipicosapi.model.Usuario;
import lombok.*;

import java.util.List;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class UsuarioDto {
    private Long id;
    private String nombre;
    private String usuario;
    private boolean estado;
    private List<RolDto> roles;

    public static UsuarioDto toDto(Usuario usuario){
        return UsuarioDto.builder()
                .id(usuario.getId())
                .nombre(usuario.getNombre())
                .usuario(usuario.getUsuario())
                .estado(usuario.isEstado())
                .roles(usuario.getRoles().stream().map(RolDto::toDto).toList())
                .build();
    }
}
