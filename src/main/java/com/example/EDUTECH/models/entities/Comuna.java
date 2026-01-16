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
@Table(name = "comuna")


public class Comuna {
    
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id_comuna;

    @Column(nullable = false)
    private String nombre_comuna;

    //ciudad fk
    @ManyToOne
    @JoinColumn (name="id_ciudad", nullable=false)
    private Ciudad id_ciudad;




}
