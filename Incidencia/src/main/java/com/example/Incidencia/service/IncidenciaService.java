package com.example.Incidencia.service;

import java.util.List;
import java.util.stream.Collectors;

import org.springframework.stereotype.Service;

import com.example.Incidencia.model.dto.IncidenciaDTO;
import com.example.Incidencia.model.entitie.Incidencia;
import com.example.Incidencia.model.request.IncidenciaRequest;
import com.example.Incidencia.repository.IncidenciaRepository;

@Service
public class IncidenciaService {

    private final IncidenciaRepository repository;

    public IncidenciaService(IncidenciaRepository repository) {
        this.repository = repository;
    }

    public List<IncidenciaDTO> listar() {
        return repository.findAll()
                .stream()
                .map(this::toDTO)
                .collect(Collectors.toList());
    }

    public IncidenciaDTO buscarPorId(Integer id) {
        return repository.findById(id)
                .map(this::toDTO)
                .orElse(null);
    }

    public IncidenciaDTO guardar(IncidenciaRequest request) {
        Incidencia incidencia = new Incidencia();
        incidencia.setTitulo(request.getTitulo());
        incidencia.setDescripcion(request.getDescripcion());
        incidencia.setEstado(request.getEstado());
        incidencia.setIdUsuario(request.getIdUsuario());

        return toDTO(repository.save(incidencia));
    }

    public IncidenciaDTO actualizar(Integer id, IncidenciaRequest request) {
        return repository.findById(id).map(incidencia -> {
            incidencia.setTitulo(request.getTitulo());
            incidencia.setDescripcion(request.getDescripcion());
            incidencia.setEstado(request.getEstado());
            incidencia.setIdUsuario(request.getIdUsuario());
            return toDTO(repository.save(incidencia));
        }).orElse(null);
    }

    public void eliminar(Integer id) {
        repository.deleteById(id);
    }

    private IncidenciaDTO toDTO(Incidencia incidencia) {
        IncidenciaDTO dto = new IncidenciaDTO();
        dto.setIdIncidencia(incidencia.getIdIncidencia());
        dto.setTitulo(incidencia.getTitulo());
        dto.setDescripcion(incidencia.getDescripcion());
        dto.setEstado(incidencia.getEstado());
        dto.setIdUsuario(incidencia.getIdUsuario());
        return dto;
    }
}
