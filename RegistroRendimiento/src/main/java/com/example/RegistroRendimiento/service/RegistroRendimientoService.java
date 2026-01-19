package com.example.RegistroRendimiento.service;

import com.example.RegistroRendimiento.model.dto.RegistroRendimientoDTO;
import com.example.RegistroRendimiento.model.entitie.RegistroRendimiento;
import com.example.RegistroRendimiento.model.request.RegistroRendimientoRequest;
import com.example.RegistroRendimiento.repository.RegistroRendimientoRepository;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;

@Service
public class RegistroRendimientoService {

    private final RegistroRendimientoRepository repository;

    public RegistroRendimientoService(RegistroRendimientoRepository repository) {
        this.repository = repository;
    }

    public List<RegistroRendimientoDTO> listar() {
        return repository.findAll()
                .stream()
                .map(this::toDTO)
                .collect(Collectors.toList());
    }

    public RegistroRendimientoDTO buscarPorId(Integer id) {
        return repository.findById(id)
                .map(this::toDTO)
                .orElse(null);
    }

    public RegistroRendimientoDTO guardar(RegistroRendimientoRequest request) {
        RegistroRendimiento registro = new RegistroRendimiento();
        registro.setIdEstudiante(request.getIdEstudiante());
        registro.setIdCurso(request.getIdCurso());
        registro.setNota(request.getNota());
        registro.setObservacion(request.getObservacion());

        return toDTO(repository.save(registro));
    }

    public RegistroRendimientoDTO actualizar(Integer id, RegistroRendimientoRequest request) {
        return repository.findById(id).map(registro -> {
            registro.setIdEstudiante(request.getIdEstudiante());
            registro.setIdCurso(request.getIdCurso());
            registro.setNota(request.getNota());
            registro.setObservacion(request.getObservacion());
            return toDTO(repository.save(registro));
        }).orElse(null);
    }

    public void eliminar(Integer id) {
        repository.deleteById(id);
    }

    private RegistroRendimientoDTO toDTO(RegistroRendimiento registro) {
        RegistroRendimientoDTO dto = new RegistroRendimientoDTO();
        dto.setIdRegistroRendimiento(registro.getIdRegistroRendimiento());
        dto.setIdEstudiante(registro.getIdEstudiante());
        dto.setIdCurso(registro.getIdCurso());
        dto.setNota(registro.getNota());
        dto.setObservacion(registro.getObservacion());
        return dto;
    }
}
