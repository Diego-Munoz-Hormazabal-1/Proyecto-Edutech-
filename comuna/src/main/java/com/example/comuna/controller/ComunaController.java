package com.example.comuna.controller;

import java.util.List;

import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.example.comuna.model.dto.ComunaDTO;
import com.example.comuna.model.request.ComunaRequest;
import com.example.comuna.service.ComunaService;

@RestController
@RequestMapping("/comunas")
public class ComunaController {

    private final ComunaService comunaService;

    public ComunaController(ComunaService comunaService) {
        this.comunaService = comunaService;
    }

    @GetMapping
    public List<ComunaDTO> listar() {
        return comunaService.listar();
    }

    @GetMapping("/{id}")
    public ComunaDTO buscarPorId(@PathVariable Integer id) {
        return comunaService.buscarPorId(id);
    }

    @PostMapping
    public ComunaDTO guardar(@RequestBody ComunaRequest request) {
        return comunaService.guardar(request);
    }

    @PutMapping("/{id}")
    public ComunaDTO actualizar(
            @PathVariable Integer id,
            @RequestBody ComunaRequest request) {
        return comunaService.actualizar(id, request);
    }

    @DeleteMapping("/{id}")
    public void eliminar(@PathVariable Integer id) {
        comunaService.eliminar(id);
    }
}
