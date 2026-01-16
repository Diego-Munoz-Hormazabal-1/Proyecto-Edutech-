package com.example.EDUTECH.models.entities;
import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;      // Define columnas específicas de la tabla
import jakarta.persistence.GenerationType;     // Marca clase como tabla en la BD
import jakarta.persistence.Id; // Genera IDs automáticos
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.Table; // Tipo de generación de IDs
import lombok.Data;         // Define clave primaria

@Entity
@Data
@Table(name="oficina")
public class Oficina {
    @Id
    @GeneratedValue(strategy=GenerationType.IDENTITY)
    private int id_oficina;

    @Column(nullable=false)
    private String estado_oficina;

    @Column(nullable=false)
    private String nombre_oficina;

    
    @ManyToOne                  // Muchos vehículos tienen UNA marca (Toyota, Ford...)
    @JoinColumn(name = "id_empresa", nullable = false) // Columna FK en esta tabla
    private Empresa empresa;  

}
