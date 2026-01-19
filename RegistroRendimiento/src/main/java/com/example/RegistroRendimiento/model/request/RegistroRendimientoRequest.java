package com.example.RegistroRendimiento.model.request;

import lombok.Data;

@Data
public class RegistroRendimientoRequest {

    private Integer idEstudiante;
    private Integer idCurso;
    private Double nota;
    private String observacion;
}
