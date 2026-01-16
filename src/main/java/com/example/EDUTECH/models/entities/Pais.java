package com.example.EDUTECH.models.entities;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.Table;
import lombok.Data;

@Entity
@Data
@Table(name = "pais")

public class Pais {
    
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private String id_pais;

    @Column(nullable = false)
    private String nombre_pais;
}
