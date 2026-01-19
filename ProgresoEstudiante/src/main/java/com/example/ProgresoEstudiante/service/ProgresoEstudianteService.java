package com.example.ProgresoEstudiante.service;

import java.util.List;
import java.util.stream.Collectors;

import org.springframework.stereotype.Service;

import com.example.ProgresoEstudiante.model.dto.ProgresoEstudianteDTO;
import com.example.ProgresoEstudiante.model.entitie.ProgresoEstudiante;
import com.example.ProgresoEstudiante.model.request.ProgresoEstudianteRequest;
import com.example.ProgresoEstudiante.repository.ProgresoEstudianteRepository;

@Service
public class ProgresoEstudianteService {

    private final ProgresoEstudianteRepository repository;

    public ProgresoEstudianteService(ProgresoEstudianteRepository repository) {
        this.repository = repository;
    }

    public List<ProgresoEstudianteDTO> listar() {
        return repository.findAll()
                .stream()
                .map(this::toDTO)
                .collect(Collectors.toList());
    }

    public ProgresoEstudianteDTO buscarPorId(Integer id) {
        return repository.findById(id)
                .map(this::toDTO)
                .orElse(null);
    }

    public ProgresoEstudianteDTO guardar(ProgresoEstudianteRequest request) {
        ProgresoEstudiante progreso = new ProgresoEstudiante();
        progreso.setIdEstudiante(request.getIdEstudiante());
        progreso.setIdCurso(request.getIdCurso());
        progreso.setPorcentajeAvance(request.getPorcentajeAvance());
        progreso.setEstado(request.getEstado());

        return toDTO(repository.save(progreso));
    }

    public ProgresoEstudianteDTO actualizar(Integer id, ProgresoEstudianteRequest request) {
        return repository.findById(id).map(progreso -> {
            progreso.setIdEstudiante(request.getIdEstudiante());
            progreso.setIdCurso(request.getIdCurso());
            progreso.setPorcentajeAvance(request.getPorcentajeAvance());
            progreso.setEstado(request.getEstado());
            return toDTO(repository.save(progreso));
        }).orElse(null);
    }

    public void eliminar(Integer id) {
        repository.deleteById(id);
    }

    private ProgresoEstudianteDTO toDTO(ProgresoEstudiante progreso) {
        ProgresoEstudianteDTO dto = new ProgresoEstudianteDTO();
        dto.setIdProgreso(progreso.getIdProgreso());
        dto.setIdEstudiante(progreso.getIdEstudiante());
        dto.setIdCurso(progreso.getIdCurso());
        dto.setPorcentajeAvance(progreso.getPorcentajeAvance());
        dto.setEstado(progreso.getEstado());
        return dto;
    }
}
