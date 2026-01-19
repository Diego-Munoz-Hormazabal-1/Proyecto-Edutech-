package com.example.ciudad.service;

import java.util.List;
import java.util.stream.Collectors;

import org.springframework.stereotype.Service;

import com.example.ciudad.model.dto.CiudadDTO;
import com.example.ciudad.model.entities.Ciudad;
import com.example.ciudad.model.request.CiudadRequest;
import com.example.ciudad.repository.CiudadRepository;

@Service
public class CiudadService {

    private final CiudadRepository ciudadRepository;

    public CiudadService(CiudadRepository ciudadRepository) {
        this.ciudadRepository = ciudadRepository;
    }

    public List<CiudadDTO> listar() {
        return ciudadRepository.findAll()
                .stream()
                .map(this::toDTO)
                .collect(Collectors.toList());
    }

    public CiudadDTO buscarPorId(Integer id) {
        return ciudadRepository.findById(id)
                .map(this::toDTO)
                .orElse(null);
    }

    public CiudadDTO guardar(CiudadRequest request) {
        Ciudad ciudad = new Ciudad();
        ciudad.setNombreCiudad(request.getNombreCiudad());
        return toDTO(ciudadRepository.save(ciudad));
    }

    public CiudadDTO actualizar(Integer id, CiudadRequest request) {
        return ciudadRepository.findById(id).map(ciudad -> {
            ciudad.setNombreCiudad(request.getNombreCiudad());
            return toDTO(ciudadRepository.save(ciudad));
        }).orElse(null);
    }

    public void eliminar(Integer id) {
        ciudadRepository.deleteById(id);
    }

    private CiudadDTO toDTO(Ciudad ciudad) {
        CiudadDTO dto = new CiudadDTO();
        dto.setIdCiudad(ciudad.getIdCiudad());
        dto.setNombreCiudad(ciudad.getNombreCiudad());
        return dto;
    }
}
