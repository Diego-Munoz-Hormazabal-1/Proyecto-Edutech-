package com.example.ContenidoEducativo.model.dto;

import lombok.Data;

@Data
public class ContenidoEducativoDTO {

    private Integer idContenido;
    private String titulo;
    private String descripcion;
    private String tipoContenido;
    private String urlContenido;
}
