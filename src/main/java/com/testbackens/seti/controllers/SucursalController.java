package com.testbackens.seti.controllers;

import com.testbackens.seti.models.Franquicia;
import com.testbackens.seti.models.Sucursal;
import com.testbackens.seti.repositories.sucursalRepository;
import com.testbackens.seti.repositories.franquiciaRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.Optional;

@RestController
@RequestMapping("/api/sucursales")
public class SucursalController {

    @Autowired
    private sucursalRepository sucursalRepository;

    @Autowired
    private franquiciaRepository franquiciaRepository;

    @PostMapping("/franquicia/{franquiciaId}")
    public ResponseEntity<Sucursal> createSucursal(@PathVariable Long franquiciaId, @RequestBody Sucursal sucursal) {
        Optional<Franquicia> franquicia = franquiciaRepository.findById(franquiciaId);
        if (franquicia.isPresent()) {
            sucursal.setFranquicia(franquicia.get());
            Sucursal nuevaSucursal = sucursalRepository.save(sucursal);
            return ResponseEntity.ok(nuevaSucursal);
        } else {
            return ResponseEntity.notFound().build();
        }
    }

    @PutMapping("/{id}")
    public ResponseEntity<Sucursal> updateSucursal(@PathVariable Long id, @RequestBody Sucursal sucursalDetails) {
        Optional<Sucursal> sucursal = sucursalRepository.findById(id);
        if (sucursal.isPresent()) {
            Sucursal sucursalToUpdate = sucursal.get();
            sucursalToUpdate.setName(sucursalDetails.getName());
            Sucursal updatedSucursal = sucursalRepository.save(sucursalToUpdate);
            return ResponseEntity.ok(updatedSucursal);
        } else {
            return ResponseEntity.notFound().build();
        }
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Void> deleteSucursal(@PathVariable Long id) {
        Optional<Sucursal> sucursal = sucursalRepository.findById(id);
        if (sucursal.isPresent()) {
            sucursalRepository.delete(sucursal.get());
            return ResponseEntity.noContent().build();
        } else {
            return ResponseEntity.notFound().build();
        }
    }
}
