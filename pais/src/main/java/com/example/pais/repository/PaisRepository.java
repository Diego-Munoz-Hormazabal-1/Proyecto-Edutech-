package com.example.pais.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.example.pais.model.entities.Pais;

public interface PaisRepository extends JpaRepository<Pais, Integer> {
}
