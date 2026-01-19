package com.example.Inscripcion.controller;

import java.util.List;

import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.example.Inscripcion.model.dto.InscripcionDTO;
import com.example.Inscripcion.model.request.InscripcionRequest;
import com.example.Inscripcion.service.InscripcionService;

@RestController
@RequestMapping("/inscripciones")
public class InscripcionController {

    private final InscripcionService service;

    public InscripcionController(InscripcionService service) {
        this.service = service;
    }

    @GetMapping
    public List<InscripcionDTO> listar() {
        return service.listar();
    }

    @GetMapping("/{id}")
    public InscripcionDTO buscarPorId(@PathVariable Integer id) {
        return service.buscarPorId(id);
    }

    @PostMapping
    public InscripcionDTO guardar(@RequestBody InscripcionRequest request) {
        return service.guardar(request);
    }

    @PutMapping("/{id}")
    public InscripcionDTO actualizar(
            @PathVariable Integer id,
            @RequestBody InscripcionRequest request) {
        return service.actualizar(id, request);
    }

    @DeleteMapping("/{id}")
    public void eliminar(@PathVariable Integer id) {
        service.eliminar(id);
    }
}
