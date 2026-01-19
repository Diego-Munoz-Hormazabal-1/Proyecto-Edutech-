package com.example.direccion.service;

import java.util.List;
import java.util.stream.Collectors;

import org.springframework.stereotype.Service;

import com.example.direccion.models.dto.DireccionDTO;
import com.example.direccion.models.entities.Direccion;
import com.example.direccion.models.requests.DireccionRequests;
import com.example.direccion.repository.DireccionRepository;

@Service
public class DireccionService {

    private final DireccionRepository direccionRepository;

    public DireccionService(DireccionRepository direccionRepository) {
        this.direccionRepository = direccionRepository;
    }

    public List<DireccionDTO> listar() {
        return direccionRepository.findAll()
                .stream()
                .map(this::toDTO)
                .collect(Collectors.toList());
    }

    public DireccionDTO buscarPorId(Integer id) {
        return direccionRepository.findById(id)
                .map(this::toDTO)
                .orElse(null);
    }

    public DireccionDTO guardar(DireccionRequests request) {
        Direccion direccion = new Direccion();
        direccion.setCalle(request.getCalle());
        direccion.setNumero(request.getNumero());
        direccion.setIdComuna(request.getIdComuna());

        return toDTO(direccionRepository.save(direccion));
    }

    public DireccionDTO actualizar(Integer id, DireccionRequests request) {
        return direccionRepository.findById(id).map(direccion -> {
            direccion.setCalle(request.getCalle());
            direccion.setNumero(request.getNumero());
            direccion.setIdComuna(request.getIdComuna());
            return toDTO(direccionRepository.save(direccion));
        }).orElse(null);
    }

    public void eliminar(Integer id) {
        direccionRepository.deleteById(id);
    }

    private DireccionDTO toDTO(Direccion direccion) {
        DireccionDTO dto = new DireccionDTO();
        dto.setIdDireccion(direccion.getIdDireccion());
        dto.setCalle(direccion.getCalle());
        dto.setNumero(direccion.getNumero());
        dto.setIdComuna(direccion.getIdComuna());
        return dto;
    }
}
