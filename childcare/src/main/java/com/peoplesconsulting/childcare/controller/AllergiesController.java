package com.peoplesconsulting.childcare.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import com.peoplesconsulting.childcare.entity.Allergies;
import com.peoplesconsulting.childcare.service.AllergiesService;

import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("/allergies")
public class AllergiesController {

    @Autowired
    private AllergiesService service;

    @GetMapping
    public List<Allergies> getAllAllergies() {
        return service.getAllAllergies();
    }

    @GetMapping("/{id}")
    public ResponseEntity<Allergies> getAllergiesById(@PathVariable("id") Long id) {
        Optional<Allergies> allergies = service.getAllergiesById(id);
        return allergies.map(value -> ResponseEntity.ok().body(value))
                .orElseGet(() -> ResponseEntity.notFound().build());
    }

    @PostMapping
    public ResponseEntity<Allergies> createAllergies(@RequestBody Allergies allergies) {
        Allergies createdAllergies = service.createAllergies(allergies);
        return ResponseEntity.status(HttpStatus.CREATED).body(createdAllergies);
    }

    @PutMapping("/{id}")
    public ResponseEntity<Allergies> updateAllergies(@PathVariable("id") Long id, @RequestBody Allergies allergies) {
        Allergies updatedAllergies = service.updateAllergies(id, allergies);
        return ResponseEntity.ok().body(updatedAllergies);
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Void> deleteAllergies(@PathVariable("id") Long id) {
        service.deleteAllergies(id);
        return ResponseEntity.noContent().build();
    }
}

