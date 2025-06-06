package com.ecomarket.spa.ecomarket_spa;

import com.ecomarket.spa.ecomarket_spa.model.*;
import com.ecomarket.spa.ecomarket_spa.repository.*;
import net.datafaker.Faker;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.context.annotation.Profile;
import org.springframework.stereotype.Component;
import java.util.Date;
import java.util.List;
import java.util.Random;
@Profile("dev")
@Component
public class DataLoader implements CommandLineRunner {
    @Autowired
    private InventoryRepository inventoryRepository;

    public void run(String... args) throws Exception {
        Faker faker = new Faker();
        Random random = new Random();

        // Generar productos
        for (int i = 0; i < 10; i++){
            InventoryItem producto = new InventoryItem();
            producto.setNombre(faker.commerce().productName());
            producto.setCantidad(faker.number().numberBetween(1, 100));
            producto.setDescripcion(faker.lorem().sentence());
            producto.setPrecio(Double.parseDouble(faker.commerce().price(5.0, 200.0)));

        }
    }
}