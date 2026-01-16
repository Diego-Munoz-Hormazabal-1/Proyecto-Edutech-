package com.example.EDUTECH.models.entities;

import jakarta.persistence.Column;      // Define columnas en la tabla
import jakarta.persistence.Entity;     // Marca clase como entidad (tabla en BD)
import jakarta.persistence.GeneratedValue; // Genera valores automáticos (IDs)
import jakarta.persistence.GenerationType; // Estrategias para generar IDs
import jakarta.persistence.Id;         // Define clave primaria de la tabla
import jakarta.persistence.JoinColumn; // Define columnas de relación FK
import jakarta.persistence.ManyToOne;  // Relación muchos-a-uno con otra tabla
import jakarta.persistence.Table;      // Especifica nombre de la tabla en BD
import lombok.Data;  

@Entity
@Data
@Table(name="contenido_educativo")

public class ContenidoEducativo {

    @Id
    @GeneratedValue(strategy=GenerationType.IDENTITY)
    private String id_contenido_educativo;

    @Column(nullable=false)
    private String nombre_contenido;

    @Column(nullable=false)
    private String tipo_contenido;

    @ManyToOne                  // Muchos vehículos tienen UNA marca (Toyota, Ford...)
    @JoinColumn(name = "id_plataforma", nullable = false) // Columna FK en esta tabla
    private PlataformaEducativa plataformaEducativa; 

}
