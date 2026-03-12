package com.ucompensar.platostipicosapi.dto;

import com.ucompensar.platostipicosapi.model.Usuario;
import lombok.*;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class UsuarioDto {
    private Long id;
    private String nombre;
    private String usuario;

    public static UsuarioDto toDto(Usuario usuario){
        return UsuarioDto.builder()
                .id(usuario.getId())
                .nombre(usuario.getNombre())
                .usuario(usuario.getUsuario())
                .build();
    }
}
