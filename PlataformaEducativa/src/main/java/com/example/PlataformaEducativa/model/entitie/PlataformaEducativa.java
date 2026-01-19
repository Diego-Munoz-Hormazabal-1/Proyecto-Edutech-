package com.example.PlataformaEducativa.model.entitie;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.Table;
import lombok.Data;

@Entity
@Table(name = "plataforma_educativa")
@Data
public class PlataformaEducativa {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer idPlataforma;

    private String nombrePlataforma;

    private String descripcion;

    private String urlPlataforma;
}

