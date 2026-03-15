package com.ucompensar.platostipicosapi.dto;

import com.ucompensar.platostipicosapi.model.Ingrediente;
import lombok.*;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class IngredienteDto {

    private Long id;
    private String nombre;

    public static IngredienteDto toDto(Ingrediente ingrediente) {

        return IngredienteDto.builder()
                .id(ingrediente.getId())
                .nombre(ingrediente.getNombre())
                .build();
    }
}
