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

@Entity
@Data
@Table(name="evaluacion")
public class Evaluacion {

    @Id
    @GeneratedValue(strategy=GenerationType.IDENTITY)
    private int id_evaluacion;

    @Column(nullable=false)
    private String nota;
    
    @Column(nullable=false)
    private LocalDate fecha_evaluacion;
    
    @ManyToOne                  // Muchos vehículos tienen UNA marca (Toyota, Ford...)
    @JoinColumn(name = "id_curso", nullable = false) // Columna FK en esta tabla
    private Curso curso; 
}
