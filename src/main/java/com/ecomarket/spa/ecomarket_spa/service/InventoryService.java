package com.ecomarket.spa.ecomarket_spa.service;

import com.ecomarket.spa.ecomarket_spa.model.InventoryItem;
import com.ecomarket.spa.ecomarket_spa.repository.InventoryRepository;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class InventoryService {

    private final InventoryRepository repository;

    public InventoryService(InventoryRepository repository) {
        this.repository = repository;
    }

    public List<InventoryItem> listarTodos() {
        return repository.findAll();
    }

    public Optional<InventoryItem> obtenerPorId(Long id) {
        return repository.findById(id);
    }

    public InventoryItem guardar(InventoryItem item) {
        return repository.save(item);
    }

    public void eliminar(Long id) {
        repository.deleteById(id);
    }
}
