package com.example.ContenidoEducativo.model.request;

import lombok.Data;

@Data
public class ContenidoEducativoRequest {

    private String titulo;
    private String descripcion;
    private String tipoContenido;
    private String urlContenido;
}
