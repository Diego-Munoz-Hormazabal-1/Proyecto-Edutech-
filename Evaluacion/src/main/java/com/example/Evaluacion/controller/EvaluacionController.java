package com.example.Evaluacion.controller;

import java.util.List;

import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.example.Evaluacion.model.dto.EvaluacionDTO;
import com.example.Evaluacion.model.request.EvaluacionRequest;
import com.example.Evaluacion.service.EvaluacionService;

@RestController
@RequestMapping("/evaluaciones")
public class EvaluacionController {

    private final EvaluacionService service;

    public EvaluacionController(EvaluacionService service) {
        this.service = service;
    }

    @GetMapping
    public List<EvaluacionDTO> listar() {
        return service.listar();
    }

    @GetMapping("/{id}")
    public EvaluacionDTO buscarPorId(@PathVariable Integer id) {
        return service.buscarPorId(id);
    }

    @PostMapping
    public EvaluacionDTO guardar(@RequestBody EvaluacionRequest request) {
        return service.guardar(request);
    }

    @PutMapping("/{id}")
    public EvaluacionDTO actualizar(
            @PathVariable Integer id,
            @RequestBody EvaluacionRequest request) {
        return service.actualizar(id, request);
    }

    @DeleteMapping("/{id}")
    public void eliminar(@PathVariable Integer id) {
        service.eliminar(id);
    }
}
