package com.example.Evaluacion.model.dto;

import lombok.Data;

@Data
public class EvaluacionDTO {

    private Integer idEvaluacion;
    private String nombreEvaluacion;
    private String descripcion;
    private Integer puntajeMaximo;
}
