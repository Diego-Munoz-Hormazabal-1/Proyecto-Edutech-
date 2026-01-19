package com.example.Incidencia.model.dto;

import lombok.Data;

@Data
public class IncidenciaDTO {

    private Integer idIncidencia;
    private String titulo;
    private String descripcion;
    private String estado;
    private Integer idUsuario;
}
