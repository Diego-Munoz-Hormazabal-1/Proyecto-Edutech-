package com.example.EDUTECH.models.entities;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.Table;
import lombok.Data;

@Data
@Entity
@Table(name="usuario")
public class Usuario {
    
    @Id
    @GeneratedValue(strategy=GenerationType.IDENTITY)
    private int id_usuario;

    @Column(nullable=false)
    private String nombre_usuario;

    @Column(nullable=false)
    private String contraseña_usuario;

    @Column(nullable=false)
    private String apellido_paterno_usuario;

    @Column(nullable=false)
    private String apellido_materno_usuario;

    @Column(nullable=false)
    private String correo;

    @Column(nullable=false)
    private String rol;

    @ManyToOne
    @JoinColumn (name="id_direccion", nullable=false)
    private Direccion id_direccion;
}
