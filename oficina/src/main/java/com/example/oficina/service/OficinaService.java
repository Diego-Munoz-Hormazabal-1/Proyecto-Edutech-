package com.example.oficina.service;

import java.util.List;
import java.util.stream.Collectors;

import org.springframework.stereotype.Service;

import com.example.oficina.model.dto.OficinaDTO;
import com.example.oficina.model.entitie.Oficina;
import com.example.oficina.model.request.OficinaRequest;
import com.example.oficina.repository.OficinaRepository;

@Service
public class OficinaService {

    private final OficinaRepository oficinaRepository;

    public OficinaService(OficinaRepository oficinaRepository) {
        this.oficinaRepository = oficinaRepository;
    }

    public List<OficinaDTO> listar() {
        return oficinaRepository.findAll()
                .stream()
                .map(this::toDTO)
                .collect(Collectors.toList());
    }

    public OficinaDTO buscarPorId(Integer id) {
        return oficinaRepository.findById(id)
                .map(this::toDTO)
                .orElse(null);
    }

    public OficinaDTO guardar(OficinaRequest request) {
        Oficina oficina = new Oficina();
        oficina.setNombreOficina(request.getNombreOficina());
        oficina.setTelefonoOficina(request.getTelefonoOficina());
        oficina.setIdEmpresa(request.getIdEmpresa());

        return toDTO(oficinaRepository.save(oficina));
    }

    public OficinaDTO actualizar(Integer id, OficinaRequest request) {
        return oficinaRepository.findById(id).map(oficina -> {
            oficina.setNombreOficina(request.getNombreOficina());
            oficina.setTelefonoOficina(request.getTelefonoOficina());
            oficina.setIdEmpresa(request.getIdEmpresa());
            return toDTO(oficinaRepository.save(oficina));
        }).orElse(null);
    }

    public void eliminar(Integer id) {
        oficinaRepository.deleteById(id);
    }

    private OficinaDTO toDTO(Oficina oficina) {
        OficinaDTO dto = new OficinaDTO();
        dto.setIdOficina(oficina.getIdOficina());
        dto.setNombreOficina(oficina.getNombreOficina());
        dto.setTelefonoOficina(oficina.getTelefonoOficina());
        dto.setIdEmpresa(oficina.getIdEmpresa());
        return dto;
    }
}
