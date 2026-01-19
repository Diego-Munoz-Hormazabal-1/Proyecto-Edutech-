package com.example.Curso.service;

import java.util.List;
import java.util.stream.Collectors;

import org.springframework.stereotype.Service;

import com.example.Curso.model.dto.CursoDTO;
import com.example.Curso.model.entitie.Curso;
import com.example.Curso.model.request.CursoRequest;
import com.example.Curso.repository.CursoRepository;

@Service
public class CursoService {

    private final CursoRepository repository;

    public CursoService(CursoRepository repository) {
        this.repository = repository;
    }

    public List<CursoDTO> listar() {
        return repository.findAll()
                .stream()
                .map(this::toDTO)
                .collect(Collectors.toList());
    }

    public CursoDTO buscarPorId(Integer id) {
        return repository.findById(id)
                .map(this::toDTO)
                .orElse(null);
    }

    public CursoDTO guardar(CursoRequest request) {
        Curso curso = new Curso();
        curso.setNombreCurso(request.getNombreCurso());
        curso.setDescripcion(request.getDescripcion());
        curso.setDuracionHoras(request.getDuracionHoras());

        return toDTO(repository.save(curso));
    }

    public CursoDTO actualizar(Integer id, CursoRequest request) {
        return repository.findById(id).map(curso -> {
            curso.setNombreCurso(request.getNombreCurso());
            curso.setDescripcion(request.getDescripcion());
            curso.setDuracionHoras(request.getDuracionHoras());
            return toDTO(repository.save(curso));
        }).orElse(null);
    }

    public void eliminar(Integer id) {
        repository.deleteById(id);
    }

    private CursoDTO toDTO(Curso curso) {
        CursoDTO dto = new CursoDTO();
        dto.setIdCurso(curso.getIdCurso());
        dto.setNombreCurso(curso.getNombreCurso());
        dto.setDescripcion(curso.getDescripcion());
        dto.setDuracionHoras(curso.getDuracionHoras());
        return dto;
    }
}
