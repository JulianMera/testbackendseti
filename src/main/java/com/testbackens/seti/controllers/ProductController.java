package com.testbackens.seti.controllers;

import com.testbackens.seti.models.Product;
import com.testbackens.seti.models.Sucursal;
import com.testbackens.seti.repositories.productRepository;
import com.testbackens.seti.repositories.sucursalRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("/api/productos")
public class ProductController {

    @Autowired
    private productRepository productRepository;

    @Autowired
    private sucursalRepository sucursalRepository;

    @PostMapping("/sucursal/{sucursalId}")
    public ResponseEntity<Product> createProduct(@PathVariable Long sucursalId, @RequestBody Product product) {
        Optional<Sucursal> sucursal = sucursalRepository.findById(sucursalId);
        if (sucursal.isPresent()) {
            product.setSucursal(sucursal.get());
            Product newProduct = productRepository.save(product);
            return ResponseEntity.ok(newProduct);
        } else {
            return ResponseEntity.notFound().build();
        }
    }

    @PutMapping("/{id}")
    public ResponseEntity<Product> updateProduct(@PathVariable Long id, @RequestBody Product productDetails) {
        Optional<Product> product = productRepository.findById(id);
        if (product.isPresent()) {
            Product productToUpdate = product.get();
            productToUpdate.setName(productDetails.getName());
            productToUpdate.setInStock(productDetails.getInStock());
            Product updatedProduct = productRepository.save(productToUpdate);
            return ResponseEntity.ok(updatedProduct);
        } else {
            return ResponseEntity.notFound().build();
        }
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Void> deleteProduct(@PathVariable Long id) {
        Optional<Product> product = productRepository.findById(id);
        if (product.isPresent()) {
            productRepository.delete(product.get());
            return ResponseEntity.noContent().build();
        } else {
            return ResponseEntity.notFound().build();
        }
    }

    // Endpoint para obtener el producto con más stock por sucursal para una franquicia dada
    @GetMapping("/max-stock/franquicia/{franquiciaId}")
    public ResponseEntity<List<Product>> getTopProductsByStockForFranquicia(@PathVariable Long franquiciaId) {
        List<Product> topProducts = productRepository.findTopProductsByStockPerSucursalForFranquicia(franquiciaId);
        return ResponseEntity.ok(topProducts);
    }
}
