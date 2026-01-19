package com.example.empresa.service;

import java.util.List;
import java.util.stream.Collectors;

import org.springframework.stereotype.Service;

import com.example.empresa.model.dto.EmpresaDTO;
import com.example.empresa.model.entitie.Empresa;
import com.example.empresa.model.request.EmpresaRequest;
import com.example.empresa.repository.EmpresaRepository;

@Service
public class EmpresaService {

    private final EmpresaRepository empresaRepository;

    public EmpresaService(EmpresaRepository empresaRepository) {
        this.empresaRepository = empresaRepository;
    }

    public List<EmpresaDTO> listar() {
        return empresaRepository.findAll()
                .stream()
                .map(this::toDTO)
                .collect(Collectors.toList());
    }

    public EmpresaDTO buscarPorId(Integer id) {
        return empresaRepository.findById(id)
                .map(this::toDTO)
                .orElse(null);
    }

    public EmpresaDTO guardar(EmpresaRequest request) {
        Empresa empresa = new Empresa();
        empresa.setNombreEmpresa(request.getNombreEmpresa());
        empresa.setRutEmpresa(request.getRutEmpresa());
        empresa.setIdDireccion(request.getIdDireccion());

        return toDTO(empresaRepository.save(empresa));
    }

    public EmpresaDTO actualizar(Integer id, EmpresaRequest request) {
        return empresaRepository.findById(id).map(empresa -> {
            empresa.setNombreEmpresa(request.getNombreEmpresa());
            empresa.setRutEmpresa(request.getRutEmpresa());
            empresa.setIdDireccion(request.getIdDireccion());
            return toDTO(empresaRepository.save(empresa));
        }).orElse(null);
    }

    public void eliminar(Integer id) {
        empresaRepository.deleteById(id);
    }

    private EmpresaDTO toDTO(Empresa empresa) {
        EmpresaDTO dto = new EmpresaDTO();
        dto.setIdEmpresa(empresa.getIdEmpresa());
        dto.setNombreEmpresa(empresa.getNombreEmpresa());
        dto.setRutEmpresa(empresa.getRutEmpresa());
        dto.setIdDireccion(empresa.getIdDireccion());
        return dto;
    }
}
