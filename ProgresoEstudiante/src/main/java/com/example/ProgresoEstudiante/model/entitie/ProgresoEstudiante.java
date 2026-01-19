package com.example.ProgresoEstudiante.model.entitie;

import jakarta.persistence.*;
import lombok.Data;

@Data
@Entity
@Table(name = "progreso_estudiante")
public class ProgresoEstudiante {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id_progreso")
    private Integer idProgreso;

    @Column(name = "id_estudiante", nullable = false)
    private Integer idEstudiante;

    @Column(name = "id_curso", nullable = false)
    private Integer idCurso;

    @Column(name = "porcentaje_avance", nullable = false)
    private Double porcentajeAvance;

    @Column(name = "estado", nullable = false)
    private String estado;
}
