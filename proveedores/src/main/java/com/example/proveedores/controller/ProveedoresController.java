package com.example.proveedores.controller;

import java.util.List;

import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.example.proveedores.model.dto.ProveedorDTO;
import com.example.proveedores.model.request.ProveedorRequest;
import com.example.proveedores.service.ProveedorService;

@RestController
@RequestMapping("/proveedores")
public class ProveedoresController {

    private final ProveedorService proveedorService;

    public ProveedoresController(ProveedorService proveedorService) {
        this.proveedorService = proveedorService;
    }

    // ===============================
    // LISTAR TODOS LOS PROVEEDORES
    // ===============================
    @GetMapping
    public List<ProveedorDTO> listar() {
        return proveedorService.listar();
    }

    // ===============================
    // BUSCAR PROVEEDOR POR ID
    // ===============================
    @GetMapping("/{id}")
    public ProveedorDTO buscarPorId(@PathVariable Integer id) {
        return proveedorService.buscarPorId(id);
    }

    // ===============================
    // CREAR PROVEEDOR
    // ===============================
    @PostMapping
    public ProveedorDTO guardar(@RequestBody ProveedorRequest request) {
        return proveedorService.guardar(request);
    }

    // ===============================
    // ACTUALIZAR PROVEEDOR
    // ===============================
    @PutMapping("/{id}")
    public ProveedorDTO actualizar(
            @PathVariable Integer id,
            @RequestBody ProveedorRequest request) {
        return proveedorService.actualizar(id, request);
    }

    // ===============================
    // ELIMINAR PROVEEDOR
    // ===============================
    @DeleteMapping("/{id}")
    public void eliminar(@PathVariable Integer id) {
        proveedorService.eliminar(id);
    }
}

