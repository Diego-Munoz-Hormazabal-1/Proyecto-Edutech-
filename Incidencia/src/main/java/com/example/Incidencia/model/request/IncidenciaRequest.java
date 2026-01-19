package com.example.Incidencia.model.request;

import lombok.Data;

@Data
public class IncidenciaRequest {

    private String titulo;
    private String descripcion;
    private String estado;
    private Integer idUsuario;
}
