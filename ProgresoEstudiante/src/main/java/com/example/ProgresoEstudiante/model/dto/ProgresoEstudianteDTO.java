package com.example.ProgresoEstudiante.model.dto;

import lombok.Data;

@Data
public class ProgresoEstudianteDTO {

    private Integer idProgreso;
    private Integer idEstudiante;
    private Integer idCurso;
    private Double porcentajeAvance;
    private String estado;
}
