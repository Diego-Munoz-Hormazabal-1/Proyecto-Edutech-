package com.example.Incidencia.controller;

import java.util.List;

import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.example.Incidencia.model.dto.IncidenciaDTO;
import com.example.Incidencia.model.request.IncidenciaRequest;
import com.example.Incidencia.service.IncidenciaService;

@RestController
@RequestMapping("/incidencias")
public class IncidenciaController {

    private final IncidenciaService service;

    public IncidenciaController(IncidenciaService service) {
        this.service = service;
    }

    @GetMapping
    public List<IncidenciaDTO> listar() {
        return service.listar();
    }

    @GetMapping("/{id}")
    public IncidenciaDTO buscarPorId(@PathVariable Integer id) {
        return service.buscarPorId(id);
    }

    @PostMapping
    public IncidenciaDTO guardar(@RequestBody IncidenciaRequest request) {
        return service.guardar(request);
    }

    @PutMapping("/{id}")
    public IncidenciaDTO actualizar(
            @PathVariable Integer id,
            @RequestBody IncidenciaRequest request) {
        return service.actualizar(id, request);
    }

    @DeleteMapping("/{id}")
    public void eliminar(@PathVariable Integer id) {
        service.eliminar(id);
    }
}
