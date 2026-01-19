package com.example.Evaluacion.service;

import java.util.List;
import java.util.stream.Collectors;

import org.springframework.stereotype.Service;

import com.example.Evaluacion.model.dto.EvaluacionDTO;
import com.example.Evaluacion.model.entitie.Evaluacion;
import com.example.Evaluacion.model.request.EvaluacionRequest;
import com.example.Evaluacion.repository.EvaluacionRepository;

@Service
public class EvaluacionService {

    private final EvaluacionRepository repository;

    public EvaluacionService(EvaluacionRepository repository) {
        this.repository = repository;
    }

    public List<EvaluacionDTO> listar() {
        return repository.findAll()
                .stream()
                .map(this::toDTO)
                .collect(Collectors.toList());
    }

    public EvaluacionDTO buscarPorId(Integer id) {
        return repository.findById(id)
                .map(this::toDTO)
                .orElse(null);
    }

    public EvaluacionDTO guardar(EvaluacionRequest request) {
        Evaluacion evaluacion = new Evaluacion();
        evaluacion.setNombreEvaluacion(request.getNombreEvaluacion());
        evaluacion.setDescripcion(request.getDescripcion());
        evaluacion.setPuntajeMaximo(request.getPuntajeMaximo());

        return toDTO(repository.save(evaluacion));
    }

    public EvaluacionDTO actualizar(Integer id, EvaluacionRequest request) {
        return repository.findById(id).map(evaluacion -> {
            evaluacion.setNombreEvaluacion(request.getNombreEvaluacion());
            evaluacion.setDescripcion(request.getDescripcion());
            evaluacion.setPuntajeMaximo(request.getPuntajeMaximo());
            return toDTO(repository.save(evaluacion));
        }).orElse(null);
    }

    public void eliminar(Integer id) {
        repository.deleteById(id);
    }

    private EvaluacionDTO toDTO(Evaluacion evaluacion) {
        EvaluacionDTO dto = new EvaluacionDTO();
        dto.setIdEvaluacion(evaluacion.getIdEvaluacion());
        dto.setNombreEvaluacion(evaluacion.getNombreEvaluacion());
        dto.setDescripcion(evaluacion.getDescripcion());
        dto.setPuntajeMaximo(evaluacion.getPuntajeMaximo());
        return dto;
    }
}
