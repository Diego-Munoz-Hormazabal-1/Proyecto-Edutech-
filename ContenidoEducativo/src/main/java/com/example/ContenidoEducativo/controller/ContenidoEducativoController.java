package com.example.ContenidoEducativo.controller;

import java.util.List;

import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.example.ContenidoEducativo.model.dto.ContenidoEducativoDTO;
import com.example.ContenidoEducativo.model.request.ContenidoEducativoRequest;
import com.example.ContenidoEducativo.service.ContenidoEducativoService;

@RestController
@RequestMapping("/contenidos-educativos")
public class ContenidoEducativoController {

    private final ContenidoEducativoService service;

    public ContenidoEducativoController(ContenidoEducativoService service) {
        this.service = service;
    }

    @GetMapping
    public List<ContenidoEducativoDTO> listar() {
        return service.listar();
    }

    @GetMapping("/{id}")
    public ContenidoEducativoDTO buscarPorId(@PathVariable Integer id) {
        return service.buscarPorId(id);
    }

    @PostMapping
    public ContenidoEducativoDTO guardar(@RequestBody ContenidoEducativoRequest request) {
        return service.guardar(request);
    }

    @PutMapping("/{id}")
    public ContenidoEducativoDTO actualizar(
            @PathVariable Integer id,
            @RequestBody ContenidoEducativoRequest request) {
        return service.actualizar(id, request);
    }

    @DeleteMapping("/{id}")
    public void eliminar(@PathVariable Integer id) {
        service.eliminar(id);
    }
}
