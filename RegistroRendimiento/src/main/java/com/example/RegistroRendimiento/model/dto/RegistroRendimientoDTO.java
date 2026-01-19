package com.example.RegistroRendimiento.model.dto;

import lombok.Data;

@Data
public class RegistroRendimientoDTO {

    private Integer idRegistroRendimiento;
    private Integer idEstudiante;
    private Integer idCurso;
    private Double nota;
    private String observacion;
}
