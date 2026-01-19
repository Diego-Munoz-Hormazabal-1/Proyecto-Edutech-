package com.example.ciudad.controller;

import java.util.List;

import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.example.ciudad.model.dto.CiudadDTO;
import com.example.ciudad.model.request.CiudadRequest;
import com.example.ciudad.service.CiudadService;

@RestController
@RequestMapping("/ciudades")
public class CiudadController {

    private final CiudadService ciudadService;

    public CiudadController(CiudadService ciudadService) {
        this.ciudadService = ciudadService;
    }

    @GetMapping
    public List<CiudadDTO> listar() {
        return ciudadService.listar();
    }

    @GetMapping("/{id}")
    public CiudadDTO buscarPorId(@PathVariable Integer id) {
        return ciudadService.buscarPorId(id);
    }

    @PostMapping
    public CiudadDTO guardar(@RequestBody CiudadRequest request) {
        return ciudadService.guardar(request);
    }

    @PutMapping("/{id}")
    public CiudadDTO actualizar(
            @PathVariable Integer id,
            @RequestBody CiudadRequest request) {
        return ciudadService.actualizar(id, request);
    }

    @DeleteMapping("/{id}")
    public void eliminar(@PathVariable Integer id) {
        ciudadService.eliminar(id);
    }
}
