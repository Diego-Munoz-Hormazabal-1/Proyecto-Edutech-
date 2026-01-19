package com.example.Curso.model.dto;

import lombok.Data;

@Data
public class CursoDTO {

    private Integer idCurso;
    private String nombreCurso;
    private String descripcion;
    private Integer duracionHoras;
}
