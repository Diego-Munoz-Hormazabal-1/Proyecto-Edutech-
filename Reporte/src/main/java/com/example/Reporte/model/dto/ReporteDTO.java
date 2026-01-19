package com.example.Reporte.model.dto;

import lombok.Data;

@Data
public class ReporteDTO {

    private Integer idReporte;
    private String titulo;
    private String descripcion;
    private String tipo;
    private String fecha;
    private Integer idUsuario;
}
