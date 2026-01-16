package com.example.EDUTECH.models.entities;

import org.hibernate.annotations.ManyToAny;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.Table;
import lombok.Data;

@Entity
@Data
@Table(name = "proovedores")
public class Proovedores {


    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id_proovedor;


    @Column(nullable = false)
    private String nombre_proovedor;

    @Column(nullable=false)
    private String tipo_proovedor;

    

    @ManyToAny
    @JoinColumn (name="id_empresa", nullable=false)
    private Empresa id_empresa;


}
