package com.example.direccion.controller;

import java.util.List;

import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.example.direccion.models.dto.DireccionDTO;
import com.example.direccion.models.requests.DireccionRequests;
import com.example.direccion.service.DireccionService;

@RestController
@RequestMapping("/direcciones")
public class DireccionController {

    private final DireccionService direccionService;

    public DireccionController(DireccionService direccionService) {
        this.direccionService = direccionService;
    }

    @GetMapping
    public List<DireccionDTO> listar() {
        return direccionService.listar();
    }

    @GetMapping("/{id}")
    public DireccionDTO buscarPorId(@PathVariable Integer id) {
        return direccionService.buscarPorId(id);
    }

    @PostMapping
    public DireccionDTO guardar(@RequestBody DireccionRequests request) {
        return direccionService.guardar(request);
    }

    @PutMapping("/{id}")
    public DireccionDTO actualizar(
            @PathVariable Integer id,
            @RequestBody DireccionRequests request) {
        return direccionService.actualizar(id, request);
    }

    @DeleteMapping("/{id}")
    public void eliminar(@PathVariable Integer id) {
        direccionService.eliminar(id);
    }
}
