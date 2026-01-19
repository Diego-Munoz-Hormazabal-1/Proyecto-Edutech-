package com.example.empresa.controller;

import java.util.List;

import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.example.empresa.model.dto.EmpresaDTO;
import com.example.empresa.model.request.EmpresaRequest;
import com.example.empresa.service.EmpresaService;

@RestController
@RequestMapping("/empresas")
public class EmpresaController {

    private final EmpresaService empresaService;

    public EmpresaController(EmpresaService empresaService) {
        this.empresaService = empresaService;
    }

    @GetMapping
    public List<EmpresaDTO> listar() {
        return empresaService.listar();
    }

    @GetMapping("/{id}")
    public EmpresaDTO buscarPorId(@PathVariable Integer id) {
        return empresaService.buscarPorId(id);
    }

    @PostMapping
    public EmpresaDTO guardar(@RequestBody EmpresaRequest request) {
        return empresaService.guardar(request);
    }

    @PutMapping("/{id}")
    public EmpresaDTO actualizar(
            @PathVariable Integer id,
            @RequestBody EmpresaRequest request) {
        return empresaService.actualizar(id, request);
    }

    @DeleteMapping("/{id}")
    public void eliminar(@PathVariable Integer id) {
        empresaService.eliminar(id);
    }
}
