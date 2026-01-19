package com.example.Inscripcion.model.request;

import lombok.Data;

@Data
public class InscripcionRequest {

    private Integer idEstudiante;
    private Integer idCurso;
    private String fechaInscripcion;
    private String estado;
}
