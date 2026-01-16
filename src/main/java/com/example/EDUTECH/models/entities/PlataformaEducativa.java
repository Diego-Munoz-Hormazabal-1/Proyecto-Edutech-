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

@Entity
@Data
@Table(name = "plataforma_educativa")

public class PlataformaEducativa {
    
    @Id
    @GeneratedValue(strategy= GenerationType.IDENTITY)
    private int id_plataforma;

    @Column(nullable=false)
    private String nombre_plataforma;

    @Column(nullable=false)
    private String version_plataforma;

    @Column(nullable=false)
    private String estado_plataforma;

    @ManyToOne                 
    @JoinColumn(name = "id_plataforma", nullable = false) 
    private Empresa id_empresa; 
    
   
}
