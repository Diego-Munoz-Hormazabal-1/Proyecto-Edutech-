package com.example.EDUTECH.models.entities;
import java.time.LocalDate;

import jakarta.persistence.Column;      // Define columnas específicas de la tabla
import jakarta.persistence.Entity;     // Marca clase como tabla en la BD
import jakarta.persistence.GeneratedValue; // Genera IDs automáticos
import jakarta.persistence.GenerationType; // Tipo de generación de IDs
import jakarta.persistence.Id;         // Define clave primaria
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.Table;      // Nombre exacto de la tabla
import lombok.Data;                    // Genera getters/setters/toString automáticamente

@Entity
@Data
@Table(name="empresa")
public class Empresa {

    @Id
    @GeneratedValue(strategy=GenerationType.IDENTITY)
    private int id_empresa;

    @Column(nullable=false)
    private String nombre_empresa;

    @Column(nullable=false)
    private String razon_social;
    
    @Column(nullable=false)
    private LocalDate fecha_cracion_empresa; // LocalDate para meter fechas

    @ManyToOne
    @JoinColumn (name="id_direccion", nullable=false)
    private Direccion id_direccion;
}
