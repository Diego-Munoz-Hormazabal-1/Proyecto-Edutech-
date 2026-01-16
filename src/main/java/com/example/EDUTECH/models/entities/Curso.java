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
@Table(name = "curso")
public class Curso {

    @Id
    @GeneratedValue(strategy=GenerationType.IDENTITY)
    private int id_curso;


    @Column(nullable=false)
    private String nombre_curso;

    @Column(nullable=false)
    private String descripcion_curso;

    @Column(nullable=false)
    private String nivel_curso;

    @Column(nullable=false)
    private String estado_curso;

    @Column(nullable=false)
    private LocalDate fecha_inicio_curso;

    @Column(nullable=false)
    private LocalDate fecha_termino_curso;

    @ManyToOne
    @JoinColumn (name="id_contenido_educativo", nullable=false)
    private ContenidoEducativo id_contenidoEducativo;


}
