package com.example.ContenidoEducativo.service;

import java.util.List;
import java.util.stream.Collectors;

import org.springframework.stereotype.Service;

import com.example.ContenidoEducativo.model.dto.ContenidoEducativoDTO;
import com.example.ContenidoEducativo.model.entitie.ContenidoEducativo;
import com.example.ContenidoEducativo.model.request.ContenidoEducativoRequest;
import com.example.ContenidoEducativo.repository.ContenidoEducativoRepository;

@Service
public class ContenidoEducativoService {

    private final ContenidoEducativoRepository repository;

    public ContenidoEducativoService(ContenidoEducativoRepository repository) {
        this.repository = repository;
    }

    public List<ContenidoEducativoDTO> listar() {
        return repository.findAll()
                .stream()
                .map(this::toDTO)
                .collect(Collectors.toList());
    }

    public ContenidoEducativoDTO buscarPorId(Integer id) {
        return repository.findById(id)
                .map(this::toDTO)
                .orElse(null);
    }

    public ContenidoEducativoDTO guardar(ContenidoEducativoRequest request) {
        ContenidoEducativo contenido = new ContenidoEducativo();
        contenido.setTitulo(request.getTitulo());
        contenido.setDescripcion(request.getDescripcion());
        contenido.setTipoContenido(request.getTipoContenido());
        contenido.setUrlContenido(request.getUrlContenido());

        return toDTO(repository.save(contenido));
    }

    public ContenidoEducativoDTO actualizar(Integer id, ContenidoEducativoRequest request) {
        return repository.findById(id).map(contenido -> {
            contenido.setTitulo(request.getTitulo());
            contenido.setDescripcion(request.getDescripcion());
            contenido.setTipoContenido(request.getTipoContenido());
            contenido.setUrlContenido(request.getUrlContenido());
            return toDTO(repository.save(contenido));
        }).orElse(null);
    }

    public void eliminar(Integer id) {
        repository.deleteById(id);
    }

    private ContenidoEducativoDTO toDTO(ContenidoEducativo contenido) {
        ContenidoEducativoDTO dto = new ContenidoEducativoDTO();
        dto.setIdContenido(contenido.getIdContenido());
        dto.setTitulo(contenido.getTitulo());
        dto.setDescripcion(contenido.getDescripcion());
        dto.setTipoContenido(contenido.getTipoContenido());
        dto.setUrlContenido(contenido.getUrlContenido());
        return dto;
    }
}
