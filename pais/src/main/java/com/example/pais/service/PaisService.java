package com.example.pais.service;

import java.util.List;
import java.util.stream.Collectors;

import org.springframework.stereotype.Service;

import com.example.pais.model.dto.PaisDTO;
import com.example.pais.model.entities.Pais;
import com.example.pais.model.request.PaisRequest;
import com.example.pais.repository.PaisRepository;

@Service
public class PaisService {

    private final PaisRepository repository;

    public PaisService(PaisRepository repository) {
        this.repository = repository;
    }

    public List<PaisDTO> listar() {
        return repository.findAll()
                .stream()
                .map(p -> new PaisDTO(p.getIdPais(), p.getNombrePais()))
                .collect(Collectors.toList());
    }

    public PaisDTO buscarPorId(int id) {
        Pais pais = repository.findById(id).orElse(null);

        if (pais == null) {
            throw new RuntimeException("Pais no encontrado");
        }

        return new PaisDTO(pais.getIdPais(), pais.getNombrePais());
    }

    public PaisDTO guardar(PaisRequest request) {
        Pais pais = new Pais();
        pais.setNombrePais(request.getNombrePais());

        Pais guardado = repository.save(pais);

        return new PaisDTO(
                guardado.getIdPais(),
                guardado.getNombrePais()
        );
    }

    public PaisDTO actualizar(int id, PaisRequest request) {
        Pais pais = repository.findById(id).orElse(null);

        if (pais == null) {
            throw new RuntimeException("Pais no encontrado");
        }

        pais.setNombrePais(request.getNombrePais());
        Pais actualizado = repository.save(pais);

        return new PaisDTO(
                actualizado.getIdPais(),
                actualizado.getNombrePais()
        );
    }

    public void eliminar(int id) {
        repository.deleteById(id);
    }
}
