package com.example.Inscripcion.model.dto;

import lombok.Data;

@Data
public class InscripcionDTO {

    private Integer idInscripcion;
    private Integer idEstudiante;
    private Integer idCurso;
    private String fechaInscripcion;
    private String estado;
}
