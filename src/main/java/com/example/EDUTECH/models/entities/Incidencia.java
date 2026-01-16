package com.example.EDUTECH.models.entities;

import java.time.LocalDate;

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
@Table(name="incidencia")

public class Incidencia {
    
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id_incidencia;


    @Column(nullable = false)
    private String tipo_incidencia;

    @Column(nullable = false)
    private String descripcion_incidencia;

    @Column(nullable = false)   
    private LocalDate fecha_incidencia;

    @ManyToOne
    @JoinColumn (name="id_plataformaEducativa", nullable=false)
    private PlataformaEducativa id_plataformaEducativa;
}
