package com.example.Curso.controller;

import java.util.List;

import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.example.Curso.model.dto.CursoDTO;
import com.example.Curso.model.request.CursoRequest;
import com.example.Curso.service.CursoService;

@RestController
@RequestMapping("/cursos")
public class CursoController {

    private final CursoService service;

    public CursoController(CursoService service) {
        this.service = service;
    }

    @GetMapping
    public List<CursoDTO> listar() {
        return service.listar();
    }

    @GetMapping("/{id}")
    public CursoDTO buscarPorId(@PathVariable Integer id) {
        return service.buscarPorId(id);
    }

    @PostMapping
    public CursoDTO guardar(@RequestBody CursoRequest request) {
        return service.guardar(request);
    }

    @PutMapping("/{id}")
    public CursoDTO actualizar(
            @PathVariable Integer id,
            @RequestBody CursoRequest request) {
        return service.actualizar(id, request);
    }

    @DeleteMapping("/{id}")
    public void eliminar(@PathVariable Integer id) {
        service.eliminar(id);
    }
}
