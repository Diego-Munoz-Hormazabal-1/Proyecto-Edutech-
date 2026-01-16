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
@Table(name="inscripcion")


public class Inscripcion {
    
    @Id
    @GeneratedValue(strategy=GenerationType.IDENTITY)
    private int id_inscripcion;

    @Column(nullable=false)
    private LocalDate fecha_inscripcion;

    @Column(nullable=false)
    private String estado_inscripcion;

    @ManyToOne
    @JoinColumn (name="id_plataformaEducativa", nullable=false)
    private PlataformaEducativa id_plataformaEducativa;

    @ManyToOne
    @JoinColumn (name="id_usuario", nullable=false)
    private Usuario id_usuario;








}
