package com.example.PlataformaEducativa.service;

import com.example.PlataformaEducativa.model.dto.PlataformaEducativaDTO;
import com.example.PlataformaEducativa.model.entitie.PlataformaEducativa;
import com.example.PlataformaEducativa.model.request.PlataformaEducativaRequest;
import com.example.PlataformaEducativa.repository.PlataformaEducativaRepository;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;

@Service
public class PlataformaEducativaService {

    private final PlataformaEducativaRepository repository;

    public PlataformaEducativaService(PlataformaEducativaRepository repository) {
        this.repository = repository;
    }

    public List<PlataformaEducativaDTO> listar() {
        return repository.findAll()
                .stream()
                .map(this::toDTO)
                .collect(Collectors.toList());
    }

    public PlataformaEducativaDTO buscarPorId(Integer id) {
        return repository.findById(id)
                .map(this::toDTO)
                .orElse(null);
    }

    public PlataformaEducativaDTO guardar(PlataformaEducativaRequest request) {
        PlataformaEducativa plataforma = new PlataformaEducativa();
        plataforma.setNombrePlataforma(request.getNombrePlataforma());
        plataforma.setDescripcion(request.getDescripcion());
        plataforma.setUrlPlataforma(request.getUrlPlataforma());
        return toDTO(repository.save(plataforma));
    }

    public PlataformaEducativaDTO actualizar(Integer id, PlataformaEducativaRequest request) {
        return repository.findById(id).map(plataforma -> {
            plataforma.setNombrePlataforma(request.getNombrePlataforma());
            plataforma.setDescripcion(request.getDescripcion());
            plataforma.setUrlPlataforma(request.getUrlPlataforma());
            return toDTO(repository.save(plataforma));
        }).orElse(null);
    }

    public void eliminar(Integer id) {
        repository.deleteById(id);
    }

    private PlataformaEducativaDTO toDTO(PlataformaEducativa plataforma) {
        PlataformaEducativaDTO dto = new PlataformaEducativaDTO();
        dto.setIdPlataforma(plataforma.getIdPlataforma());
        dto.setNombrePlataforma(plataforma.getNombrePlataforma());
        dto.setDescripcion(plataforma.getDescripcion());
        dto.setUrlPlataforma(plataforma.getUrlPlataforma());
        return dto;
    }
}
