package com.peoplesconsulting.childcare.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import com.peoplesconsulting.childcare.entity.Medications;
import com.peoplesconsulting.childcare.service.MedicationsService;

import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("/medications")
public class MedicationsController {

    @Autowired
    private MedicationsService service;

    @GetMapping
    public List<Medications> getAllMedications() {
        return service.getAllMedications();
    }

    @GetMapping("/{id}")
    public ResponseEntity<Medications> getMedicationsById(@PathVariable("id") Long id) {
        Optional<Medications> medications = service.getMedicationsById(id);
        return medications.map(value -> ResponseEntity.ok().body(value))
                .orElseGet(() -> ResponseEntity.notFound().build());
    }

    @PostMapping
    public ResponseEntity<Medications> createMedications(@RequestBody Medications medications) {
        Medications createdMedications = service.createMedications(medications);
        return ResponseEntity.status(HttpStatus.CREATED).body(createdMedications);
    }

    @PutMapping("/{id}")
    public ResponseEntity<Medications> updateMedications(@PathVariable("id") Long id, @RequestBody Medications medications) {
        Medications updatedMedications = service.updateMedications(id, medications);
        return ResponseEntity.ok().body(updatedMedications);
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Void> deleteMedications(@PathVariable("id") Long id) {
        service.deleteMedications(id);
        return ResponseEntity.noContent().build();
    }
}

