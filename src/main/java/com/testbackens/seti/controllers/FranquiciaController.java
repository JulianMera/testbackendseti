package com.testbackens.seti.controllers;

import com.testbackens.seti.repositories.franquiciaRepository;
import com.testbackens.seti.models.Franquicia;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.Optional;

@RestController
@RequestMapping("api/franquicias")
public class FranquiciaController {

    @Autowired
    private franquiciaRepository franquiciaRepository;

    @PostMapping
    public Franquicia addFranquicia(@RequestBody Franquicia franquicia) {
        return  franquiciaRepository.save(franquicia);
    }

    @PutMapping("/{id}")
    public ResponseEntity<Franquicia> updateFranquicia(@PathVariable Long id, @RequestBody Franquicia franquiciaDetails) {
        Optional<Franquicia> franquicia = franquiciaRepository.findById(id);
        if (franquicia.isPresent()) {
            Franquicia franquiciaToUpdate = franquicia.get();
            franquiciaToUpdate.setName(franquiciaDetails.getName());
            Franquicia updatedFranquicia = franquiciaRepository.save(franquiciaToUpdate);
            return ResponseEntity.ok(updatedFranquicia);
        } else {
            return ResponseEntity.notFound().build();
        }
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Void> deleteFranquicia(@PathVariable Long id) {
        Optional<Franquicia> franquicia = franquiciaRepository.findById(id);
        if (franquicia.isPresent()) {
            franquiciaRepository.delete(franquicia.get());
            return ResponseEntity.noContent().build();
        } else {
            return ResponseEntity.notFound().build();
        }
    }
}
