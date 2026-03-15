package com.ucompensar.platostipicosapi.dto;

import com.ucompensar.platostipicosapi.model.Plato;
import lombok.*;

import java.util.List;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class PlatoDto {
    private Long id;
    private String nombre;
    private int porciones;
    private boolean destacado;
    private int tiempoPreparacion;
    private String datoCurioso;
    private String historia;
    private String descripcion;
    private UsuarioDto usuario;
    private CategoriaDto categoria;
    private DepartamentoDto departamento;
    private List<IngredienteDto> ingredientes;
    private List<ComentarioDto> comentarios;
    private List<GaleriaDto> galeria;


    public static PlatoDto toDto(Plato plato) {
        return PlatoDto.builder()
                .id(plato.getId())
                .nombre(plato.getNombre())
                .porciones(plato.getPorciones())
                .destacado(plato.isDestacado())
                .tiempoPreparacion(plato.getTiempoPreparacion())
                .datoCurioso(plato.getDatoCurioso())
                .historia(plato.getHistoria())
                .descripcion(plato.getDescripcion())
                .departamento(DepartamentoDto.toDto(plato.getDepartamento()))
                .categoria(CategoriaDto.toDto(plato.getCategoria()))
                .ingredientes(plato.getIngredientes().stream().map(IngredienteDto::toDto).toList())
                .comentarios(plato.getComentarios().stream().map(ComentarioDto::toDto).toList())
                .galeria(plato.getGaleria().stream().map(GaleriaDto::toDto).toList())
                .build();
    }
}
