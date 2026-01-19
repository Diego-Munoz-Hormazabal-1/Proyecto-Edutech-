package com.example.proveedores.service;

import java.util.List;
import java.util.stream.Collectors;

import org.springframework.stereotype.Service;

import com.example.proveedores.model.dto.ProveedorDTO;
import com.example.proveedores.model.entitie.Proveedor;
import com.example.proveedores.model.request.ProveedorRequest;
import com.example.proveedores.repository.ProveedorRepository;

@Service
public class ProveedorService {

    private final ProveedorRepository proveedorRepository;

    public ProveedorService(ProveedorRepository proveedorRepository) {
        this.proveedorRepository = proveedorRepository;
    }

    public List<ProveedorDTO> listar() {
        return proveedorRepository.findAll()
                .stream()
                .map(this::toDTO)
                .collect(Collectors.toList());
    }

    public ProveedorDTO buscarPorId(Integer id) {
        return proveedorRepository.findById(id)
                .map(this::toDTO)
                .orElse(null);
    }

    public ProveedorDTO guardar(ProveedorRequest request) {
        Proveedor proveedor = new Proveedor();
        proveedor.setNombreProveedor(request.getNombreProveedor());
        proveedor.setRutProveedor(request.getRutProveedor());
        proveedor.setIdEmpresa(request.getIdEmpresa());

        return toDTO(proveedorRepository.save(proveedor));
    }

    public ProveedorDTO actualizar(Integer id, ProveedorRequest request) {
        return proveedorRepository.findById(id).map(proveedor -> {
            proveedor.setNombreProveedor(request.getNombreProveedor());
            proveedor.setRutProveedor(request.getRutProveedor());
            proveedor.setIdEmpresa(request.getIdEmpresa());
            return toDTO(proveedorRepository.save(proveedor));
        }).orElse(null);
    }

    public void eliminar(Integer id) {
        proveedorRepository.deleteById(id);
    }

    private ProveedorDTO toDTO(Proveedor proveedor) {
        ProveedorDTO dto = new ProveedorDTO();
        dto.setIdProveedor(proveedor.getIdProveedor());
        dto.setNombreProveedor(proveedor.getNombreProveedor());
        dto.setRutProveedor(proveedor.getRutProveedor());
        dto.setIdEmpresa(proveedor.getIdEmpresa());
        return dto;
    }
}
