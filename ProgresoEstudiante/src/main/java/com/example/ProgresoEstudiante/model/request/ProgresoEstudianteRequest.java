package com.example.ProgresoEstudiante.model.request;

import lombok.Data;

@Data
public class ProgresoEstudianteRequest {

    private Integer idEstudiante;
    private Integer idCurso;
    private Double porcentajeAvance;
    private String estado;
}
