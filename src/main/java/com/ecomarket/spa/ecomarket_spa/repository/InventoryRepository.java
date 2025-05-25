package com.ecomarket.spa.ecomarket_spa.repository;

import com.ecomarket.spa.ecomarket_spa.model.InventoryItem;
import org.springframework.data.jpa.repository.JpaRepository;

public interface InventoryRepository extends JpaRepository<InventoryItem, Long> {
}
