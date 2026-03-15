package com.ucompensar.platostipicosapi.dto;

import com.ucompensar.platostipicosapi.model.Comentario;
import lombok.*;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class ComentarioDto {
    private Long id;
    private String nombre;
    private String comentario;
    private String fecha;

    public static ComentarioDto toDto(Comentario comentario) {
        return ComentarioDto.builder()
                .id(comentario.getId())
                .nombre(comentario.getNombre())
                .comentario(comentario.getComentario())
                .fecha(comentario.getFecha().toString())
                .build();
    }
}
