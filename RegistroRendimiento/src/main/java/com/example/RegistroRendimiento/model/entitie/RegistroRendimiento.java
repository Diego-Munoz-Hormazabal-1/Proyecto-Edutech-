package com.example.RegistroRendimiento.model.entitie;

import jakarta.persistence.*;
import lombok.Data;

@Data
@Entity
@Table(name = "registro_rendimiento")
public class RegistroRendimiento {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id_registro_rendimiento")
    private Integer idRegistroRendimiento;

    @Column(name = "id_estudiante", nullable = false)
    private Integer idEstudiante;

    @Column(name = "id_curso", nullable = false)
    private Integer idCurso;

    @Column(name = "nota", nullable = false)
    private Double nota;

    @Column(name = "observacion")
    private String observacion;
}
