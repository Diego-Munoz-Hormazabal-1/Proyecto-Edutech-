package com.example.Reporte.service;

import java.util.List;
import java.util.stream.Collectors;

import org.springframework.stereotype.Service;

import com.example.Reporte.model.dto.ReporteDTO;
import com.example.Reporte.model.entitie.Reporte;
import com.example.Reporte.model.request.ReporteRequest;
import com.example.Reporte.repository.ReporteRepository;

@Service
public class ReporteService {

    private final ReporteRepository repository;

    public ReporteService(ReporteRepository repository) {
        this.repository = repository;
    }

    public List<ReporteDTO> listar() {
        return repository.findAll()
                .stream()
                .map(this::toDTO)
                .collect(Collectors.toList());
    }

    public ReporteDTO buscarPorId(Integer id) {
        return repository.findById(id)
                .map(this::toDTO)
                .orElse(null);
    }

    public ReporteDTO guardar(ReporteRequest request) {
        Reporte reporte = new Reporte();
        reporte.setTitulo(request.getTitulo());
        reporte.setDescripcion(request.getDescripcion());
        reporte.setTipo(request.getTipo());
        reporte.setFecha(request.getFecha());
        reporte.setIdUsuario(request.getIdUsuario());

        return toDTO(repository.save(reporte));
    }

    public ReporteDTO actualizar(Integer id, ReporteRequest request) {
        return repository.findById(id).map(reporte -> {
            reporte.setTitulo(request.getTitulo());
            reporte.setDescripcion(request.getDescripcion());
            reporte.setTipo(request.getTipo());
            reporte.setFecha(request.getFecha());
            reporte.setIdUsuario(request.getIdUsuario());
            return toDTO(repository.save(reporte));
        }).orElse(null);
    }

    public void eliminar(Integer id) {
        repository.deleteById(id);
    }

    private ReporteDTO toDTO(Reporte reporte) {
        ReporteDTO dto = new ReporteDTO();
        dto.setIdReporte(reporte.getIdReporte());
        dto.setTitulo(reporte.getTitulo());
        dto.setDescripcion(reporte.getDescripcion());
        dto.setTipo(reporte.getTipo());
        dto.setFecha(reporte.getFecha());
        dto.setIdUsuario(reporte.getIdUsuario());
        return dto;
    }
}
