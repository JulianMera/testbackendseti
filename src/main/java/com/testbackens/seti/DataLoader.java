package com.testbackens.seti;

import com.testbackens.seti.models.Franquicia;
import com.testbackens.seti.models.Sucursal;
import com.testbackens.seti.models.Product;
import com.testbackens.seti.repositories.franquiciaRepository;
import com.testbackens.seti.repositories.sucursalRepository;
import com.testbackens.seti.repositories.productRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.stereotype.Component;

@Component
public class DataLoader implements CommandLineRunner {

    @Autowired
    private franquiciaRepository franquiciaRepository;

    @Autowired
    private sucursalRepository sucursalRepository;

    @Autowired
    private productRepository productRepository;

    @Override
    public void run(String... args) throws Exception {
        // Crear franquicias
        Franquicia franquicia1 = new Franquicia("Franquicia 1");
        Franquicia franquicia2 = new Franquicia("Franquicia 2");
        franquiciaRepository.save(franquicia1);
        franquiciaRepository.save(franquicia2);

        // Crear sucursales
        Sucursal sucursal1 = new Sucursal("Sucursal 1", franquicia1);
        Sucursal sucursal2 = new Sucursal("Sucursal 2", franquicia1);
        Sucursal sucursal3 = new Sucursal("Sucursal 3", franquicia2);
        sucursalRepository.save(sucursal1);
        sucursalRepository.save(sucursal2);
        sucursalRepository.save(sucursal3);

        // Crear productos
        Product productoA = new Product("Producto A", 100, sucursal1);
        Product productoB = new Product("Producto B", 200, sucursal1);
        Product productoC = new Product("Producto C", 50, sucursal2);
        Product productoD = new Product("Producto D", 300, sucursal3);
        productRepository.save(productoA);
        productRepository.save(productoB);
        productRepository.save(productoC);
        productRepository.save(productoD);
    }

}
