package com.example.direccion.models.dto;

import lombok.Data;

@Data
public class DireccionDTO {

    private Integer idDireccion;
    private String calle;
    private String numero;
    private Integer idComuna;
}
