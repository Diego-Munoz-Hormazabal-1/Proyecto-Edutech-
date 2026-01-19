package com.example.Curso.model.entitie;

import jakarta.persistence.*;
import lombok.Data;

@Entity
@Table(name = "curso")
@Data
public class Curso {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer idCurso;

    private String nombreCurso;
    private String descripcion;
    private Integer duracionHoras;
}
