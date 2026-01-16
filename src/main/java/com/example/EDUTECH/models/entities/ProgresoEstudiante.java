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
@Table(name = "progreso_estudiante")

public class ProgresoEstudiante {

    @Id
    @GeneratedValue(strategy=GenerationType.IDENTITY)
    private int id_progreso;

    @Column(nullable=false)
    private String creditos_aprobados;

    @Column(nullable=false)
    private String registro_evaluacion;


    @ManyToOne
    @JoinColumn (name="id_usuario", nullable=false)
    private Usuario id_usuario;



}
