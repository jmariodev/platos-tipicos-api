package com.ucompensar.platostipicosapi.dto;

import com.ucompensar.platostipicosapi.model.Categoria;
import lombok.*;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class CategoriaDto {

    private Long id;
    private String nombre;

    public static CategoriaDto toDto(Categoria categoria) {
        return CategoriaDto.builder()
                .id(categoria.getId())
                .nombre(categoria.getNombre())
                .build();
    }
}
