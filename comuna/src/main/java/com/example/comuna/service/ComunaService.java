package com.example.comuna.service;

import java.util.List;
import java.util.stream.Collectors;

import org.springframework.stereotype.Service;

import com.example.comuna.model.dto.ComunaDTO;
import com.example.comuna.model.entities.Comuna;
import com.example.comuna.model.request.ComunaRequest;
import com.example.comuna.repository.ComunaRepository;

@Service
public class ComunaService {

    private final ComunaRepository comunaRepository;

    public ComunaService(ComunaRepository comunaRepository) {
        this.comunaRepository = comunaRepository;
    }

    public List<ComunaDTO> listar() {
        return comunaRepository.findAll()
                .stream()
                .map(this::toDTO)
                .collect(Collectors.toList());
    }

    public ComunaDTO buscarPorId(Integer id) {
        return comunaRepository.findById(id)
                .map(this::toDTO)
                .orElse(null);
    }

    public ComunaDTO guardar(ComunaRequest request) {
        Comuna comuna = new Comuna();
        comuna.setNombreComuna(request.getNombreComuna());
        comuna.setIdCiudad(request.getIdCiudad());
        return toDTO(comunaRepository.save(comuna));
    }

    public ComunaDTO actualizar(Integer id, ComunaRequest request) {
        return comunaRepository.findById(id).map(comuna -> {
            comuna.setNombreComuna(request.getNombreComuna());
            comuna.setIdCiudad(request.getIdCiudad());
            return toDTO(comunaRepository.save(comuna));
        }).orElse(null);
    }

    public void eliminar(Integer id) {
        comunaRepository.deleteById(id);
    }

    private ComunaDTO toDTO(Comuna comuna) {
        ComunaDTO dto = new ComunaDTO();
        dto.setIdComuna(comuna.getIdComuna());
        dto.setNombreComuna(comuna.getNombreComuna());
        dto.setIdCiudad(comuna.getIdCiudad());
        return dto;
    }
}
