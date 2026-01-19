package com.example.Evaluacion.model.request;

import lombok.Data;

@Data
public class EvaluacionRequest {

    private String nombreEvaluacion;
    private String descripcion;
    private Integer puntajeMaximo;
}
