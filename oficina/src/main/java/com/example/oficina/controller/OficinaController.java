package com.example.oficina.controller;

import java.util.List;

import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.example.oficina.model.dto.OficinaDTO;
import com.example.oficina.model.request.OficinaRequest;
import com.example.oficina.service.OficinaService;

@RestController
@RequestMapping("/oficinas")
public class OficinaController {

    private final OficinaService oficinaService;

    public OficinaController(OficinaService oficinaService) {
        this.oficinaService = oficinaService;
    }

    @GetMapping
    public List<OficinaDTO> listar() {
        return oficinaService.listar();
    }

    @GetMapping("/{id}")
    public OficinaDTO buscarPorId(@PathVariable Integer id) {
        return oficinaService.buscarPorId(id);
    }

    @PostMapping
    public OficinaDTO guardar(@RequestBody OficinaRequest request) {
        return oficinaService.guardar(request);
    }

    @PutMapping("/{id}")
    public OficinaDTO actualizar(
            @PathVariable Integer id,
            @RequestBody OficinaRequest request) {
        return oficinaService.actualizar(id, request);
    }

    @DeleteMapping("/{id}")
    public void eliminar(@PathVariable Integer id) {
        oficinaService.eliminar(id);
    }
}

