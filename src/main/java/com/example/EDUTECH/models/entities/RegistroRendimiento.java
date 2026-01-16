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
@Table(name = "registroRendimiento")

public class RegistroRendimiento {


    @Id
    @GeneratedValue(strategy=GenerationType.IDENTITY)
    private int id_registro_rendimiento;

    @Column(nullable=false)
    private String tiempo_respuesta_registro;

    @Column(nullable=false)
    private String disponibilidad_registro;

    @ManyToOne
    @JoinColumn (name="id_plataformaEducativa", nullable=false)
    private PlataformaEducativa id_plataformaEducativa;



}
