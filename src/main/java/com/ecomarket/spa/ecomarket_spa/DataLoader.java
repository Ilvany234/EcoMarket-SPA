package com.ecomarket.spa.ecomarket_spa;

import com.ecomarket.spa.ecomarket_spa.model.InventoryItem;
import com.ecomarket.spa.ecomarket_spa.repository.InventoryRepository;
import net.datafaker.Faker;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.context.annotation.Profile;
import org.springframework.stereotype.Component;

import java.util.Locale;

@Profile("dev")
@Component
public class DataLoader implements CommandLineRunner {

    @Autowired
    private InventoryRepository inventoryRepository;

    @Override
    public void run(String... args) throws Exception {
        // Usar Faker con configuración regional en español
        Faker faker = new Faker(new Locale("es"));

        // Generar productos
        for (int i = 0; i < 10; i++) {
            InventoryItem producto = new InventoryItem();
            producto.setNombre(faker.commerce().productName());                // Nombre de producto en español
            producto.setCantidad(faker.number().numberBetween(1, 100));
            producto.setDescripcion(faker.commerce().material());               // Oración aleatoria en español
            producto.setPrecio(Double.parseDouble(faker.commerce().price(5.0, 200.0)));

            inventoryRepository.save(producto);
        }
    }
}
