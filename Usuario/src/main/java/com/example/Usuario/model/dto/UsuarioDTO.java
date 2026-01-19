package com.example.Usuario.model.dto;

import lombok.Data;

@Data
public class UsuarioDTO {

    private Integer idUsuario;
    private String nombre;
    private String email;
    private String rol;
    private String estado;
}
