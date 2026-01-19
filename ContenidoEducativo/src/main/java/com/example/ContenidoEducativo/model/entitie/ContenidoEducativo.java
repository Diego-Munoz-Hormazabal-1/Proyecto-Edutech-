package com.example.ContenidoEducativo.model.entitie;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.Table;
import lombok.Data;

@Entity
@Table(name = "contenido_educativo")
@Data
public class ContenidoEducativo {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer idContenido;

    private String titulo;
    private String descripcion;
    private String tipoContenido;
    private String urlContenido;
}
