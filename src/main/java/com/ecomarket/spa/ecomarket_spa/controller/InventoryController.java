package com.ecomarket.spa.ecomarket_spa.controller;

import com.ecomarket.spa.ecomarket_spa.model.InventoryItem;
import com.ecomarket.spa.ecomarket_spa.service.InventoryService;
import org.springframework.web.bind.annotation.*;

        import java.util.List;

@RestController
@RequestMapping("/api/inventario")
public class InventoryController {

    private final InventoryService service;

    public InventoryController(InventoryService service) {
        this.service = service;
    }

    @GetMapping
    public List<InventoryItem> listar() {
        return service.listarTodos();
    }

    @PostMapping
    public InventoryItem agregar(@RequestBody InventoryItem item) {
        return service.guardar(item);
    }

    @GetMapping("/{id}")
    public InventoryItem obtener(@PathVariable Long id) {
        return service.obtenerPorId(id).orElseThrow();
    }

    @DeleteMapping("/{id}")
    public void eliminar(@PathVariable Long id) {
        service.eliminar(id);
    }
}
