package com.example.pais.controller;

import java.util.List;

import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.example.pais.model.dto.PaisDTO;
import com.example.pais.model.request.PaisRequest;
import com.example.pais.service.PaisService;

@RestController
@RequestMapping("/paises")
public class PaisController {

    private final PaisService service;

    public PaisController(PaisService service) {
        this.service = service;
    }

    @GetMapping
    public List<PaisDTO> listar() {
        return service.listar();
    }

    @GetMapping("/{id}")
    public PaisDTO buscarPorId(@PathVariable int id) {
        return service.buscarPorId(id);
    }

    @PostMapping
    public PaisDTO guardar(@RequestBody PaisRequest request) {
        return service.guardar(request);
    }

    @PutMapping("/{id}")
    public PaisDTO actualizar(
            @PathVariable int id,
            @RequestBody PaisRequest request) {
        return service.actualizar(id, request);
    }

    @DeleteMapping("/{id}")
    public void eliminar(@PathVariable int id) {
        service.eliminar(id);
    }
}
