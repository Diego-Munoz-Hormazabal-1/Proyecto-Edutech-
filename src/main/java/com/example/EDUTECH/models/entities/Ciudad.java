package com.example.EDUTECH.models.entities;

/*
 * ========================================
 * IMPORTS DE JPA Y LOMBOK PARA ENTIDAD MARCA
 * ========================================
 * Librerías para convertir esta clase en tabla de base de datos
 */
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
@Table(name = "ciudad")
public class Ciudad {

    @Id
    @GeneratedValue(strategy=GenerationType.IDENTITY)
    private int id_ciudad;

    @Column(nullable=false)
    private String nombre_ciudad;
    
    /*
     * ========================================
     * RELACIÓN CON TABLA MARCA (OBLIGATORIA)
     * ========================================
     */
    @ManyToOne                  // Muchos vehículos tienen UNA marca (Toyota, Ford...)
    @JoinColumn(name = "id_pais", nullable = false) // Columna FK en esta tabla
    private Pais pais;        // Objeto Marca relacionado (viene de otra clase/entidad)
}

