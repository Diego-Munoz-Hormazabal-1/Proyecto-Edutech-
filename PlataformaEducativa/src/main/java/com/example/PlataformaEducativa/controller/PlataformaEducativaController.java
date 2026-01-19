package com.example.PlataformaEducativa.controller;

import java.util.List;

import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.example.PlataformaEducativa.model.dto.PlataformaEducativaDTO;
import com.example.PlataformaEducativa.model.request.PlataformaEducativaRequest;
import com.example.PlataformaEducativa.service.PlataformaEducativaService;

@RestController
@RequestMapping("/plataformas-educativas")
public class PlataformaEducativaController {

    private final PlataformaEducativaService service;

    public PlataformaEducativaController(PlataformaEducativaService service) {
        this.service = service;
    }

    @GetMapping
    public List<PlataformaEducativaDTO> listar() {
        return service.listar();
    }

    @GetMapping("/{id}")
    public PlataformaEducativaDTO buscarPorId(@PathVariable Integer id) {
        return service.buscarPorId(id);
    }

    @PostMapping
    public PlataformaEducativaDTO guardar(@RequestBody PlataformaEducativaRequest request) {
        return service.guardar(request);
    }

    @PutMapping("/{id}")
    public PlataformaEducativaDTO actualizar(
            @PathVariable Integer id,
            @RequestBody PlataformaEducativaRequest request) {
        return service.actualizar(id, request);
    }

    @DeleteMapping("/{id}")
    public void eliminar(@PathVariable Integer id) {
        service.eliminar(id);
    }
}
