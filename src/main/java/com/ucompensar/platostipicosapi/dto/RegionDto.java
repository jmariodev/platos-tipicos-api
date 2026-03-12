package com.ucompensar.platostipicosapi.dto;

import com.ucompensar.platostipicosapi.model.Region;
import lombok.*;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class RegionDto {

    private Long id;
    private String nombre;

    public static RegionDto toDto(Region region){
        return RegionDto.builder()
                .id(region.getId())
                .nombre(region.getNombre())
                .build();
    }
}
