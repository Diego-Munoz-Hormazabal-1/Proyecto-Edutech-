package com.example.Inscripcion.service;

import java.util.List;
import java.util.stream.Collectors;

import org.springframework.stereotype.Service;

import com.example.Inscripcion.model.dto.InscripcionDTO;
import com.example.Inscripcion.model.entitie.Inscripcion;
import com.example.Inscripcion.model.request.InscripcionRequest;
import com.example.Inscripcion.repository.InscripcionRepository;

@Service
public class InscripcionService {

    private final InscripcionRepository repository;

    public InscripcionService(InscripcionRepository repository) {
        this.repository = repository;
    }

    public List<InscripcionDTO> listar() {
        return repository.findAll()
                .stream()
                .map(this::toDTO)
                .collect(Collectors.toList());
    }

    public InscripcionDTO buscarPorId(Integer id) {
        return repository.findById(id)
                .map(this::toDTO)
                .orElse(null);
    }

    public InscripcionDTO guardar(InscripcionRequest request) {
        Inscripcion inscripcion = new Inscripcion();
        inscripcion.setIdEstudiante(request.getIdEstudiante());
        inscripcion.setIdCurso(request.getIdCurso());
        inscripcion.setFechaInscripcion(request.getFechaInscripcion());
        inscripcion.setEstado(request.getEstado());

        return toDTO(repository.save(inscripcion));
    }

    public InscripcionDTO actualizar(Integer id, InscripcionRequest request) {
        return repository.findById(id).map(inscripcion -> {
            inscripcion.setIdEstudiante(request.getIdEstudiante());
            inscripcion.setIdCurso(request.getIdCurso());
            inscripcion.setFechaInscripcion(request.getFechaInscripcion());
            inscripcion.setEstado(request.getEstado());
            return toDTO(repository.save(inscripcion));
        }).orElse(null);
    }

    public void eliminar(Integer id) {
        repository.deleteById(id);
    }

    private InscripcionDTO toDTO(Inscripcion inscripcion) {
        InscripcionDTO dto = new InscripcionDTO();
        dto.setIdInscripcion(inscripcion.getIdInscripcion());
        dto.setIdEstudiante(inscripcion.getIdEstudiante());
        dto.setIdCurso(inscripcion.getIdCurso());
        dto.setFechaInscripcion(inscripcion.getFechaInscripcion());
        dto.setEstado(inscripcion.getEstado());
        return dto;
    }
}
