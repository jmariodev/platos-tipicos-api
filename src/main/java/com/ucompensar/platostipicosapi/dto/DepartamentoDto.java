package com.ucompensar.platostipicosapi.dto;

import com.ucompensar.platostipicosapi.model.Departamento;
import lombok.*;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@Builder
public class DepartamentoDto {

    private Long id;
    private String nombre;
    private Long regionId;

    public static DepartamentoDto toDto(Departamento departamento) {

        if (departamento.getRegion() == null) {
            return DepartamentoDto.builder()
                    .id(departamento.getId())
                    .nombre(departamento.getNombre())
                    .build();
        }

        return DepartamentoDto.builder()
                .id(departamento.getId())
                .nombre(departamento.getNombre())
                .regionId(departamento.getRegion().getId())
                .build();

    }
}
