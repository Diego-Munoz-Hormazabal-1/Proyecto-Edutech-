package com.example.ProgresoEstudiante.controller;

import java.util.List;

import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.example.ProgresoEstudiante.model.dto.ProgresoEstudianteDTO;
import com.example.ProgresoEstudiante.model.request.ProgresoEstudianteRequest;
import com.example.ProgresoEstudiante.service.ProgresoEstudianteService;

@RestController
@RequestMapping("/progreso-estudiantes")
public class ProgresoEstudianteController {

    private final ProgresoEstudianteService service;

    public ProgresoEstudianteController(ProgresoEstudianteService service) {
        this.service = service;
    }

    @GetMapping
    public List<ProgresoEstudianteDTO> listar() {
        return service.listar();
    }

    @GetMapping("/{id}")
    public ProgresoEstudianteDTO buscarPorId(@PathVariable Integer id) {
        return service.buscarPorId(id);
    }

    @PostMapping
    public ProgresoEstudianteDTO guardar(
            @RequestBody ProgresoEstudianteRequest request) {
        return service.guardar(request);
    }

    @PutMapping("/{id}")
    public ProgresoEstudianteDTO actualizar(
            @PathVariable Integer id,
            @RequestBody ProgresoEstudianteRequest request) {
        return service.actualizar(id, request);
    }

    @DeleteMapping("/{id}")
    public void eliminar(@PathVariable Integer id) {
        service.eliminar(id);
    }
}

