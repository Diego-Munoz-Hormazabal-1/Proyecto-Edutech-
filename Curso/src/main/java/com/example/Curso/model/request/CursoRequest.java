package com.example.Curso.model.request;

import lombok.Data;

@Data
public class CursoRequest {

    private String nombreCurso;
    private String descripcion;
    private Integer duracionHoras;
}
