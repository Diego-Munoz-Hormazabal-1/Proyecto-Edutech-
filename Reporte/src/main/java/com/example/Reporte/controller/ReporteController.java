package com.example.Reporte.controller;

import java.util.List;

import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.example.Reporte.model.dto.ReporteDTO;
import com.example.Reporte.model.request.ReporteRequest;
import com.example.Reporte.service.ReporteService;

@RestController
@RequestMapping("/reportes")
public class ReporteController {

    private final ReporteService service;

    public ReporteController(ReporteService service) {
        this.service = service;
    }

    @GetMapping
    public List<ReporteDTO> listar() {
        return service.listar();
    }

    @GetMapping("/{id}")
    public ReporteDTO buscarPorId(@PathVariable Integer id) {
        return service.buscarPorId(id);
    }

    @PostMapping
    public ReporteDTO guardar(@RequestBody ReporteRequest request) {
        return service.guardar(request);
    }

    @PutMapping("/{id}")
    public ReporteDTO actualizar(
            @PathVariable Integer id,
            @RequestBody ReporteRequest request) {
        return service.actualizar(id, request);
    }

    @DeleteMapping("/{id}")
    public void eliminar(@PathVariable Integer id) {
        service.eliminar(id);
    }
}
