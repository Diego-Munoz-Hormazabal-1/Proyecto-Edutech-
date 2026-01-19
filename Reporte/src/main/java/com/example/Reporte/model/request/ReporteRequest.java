package com.example.Reporte.model.request;

import lombok.Data;

@Data
public class ReporteRequest {

    private String titulo;
    private String descripcion;
    private String tipo;
    private String fecha;
    private Integer idUsuario;
}
