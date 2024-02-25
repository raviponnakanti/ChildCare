package com.peoplesconsulting.childcare.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import com.peoplesconsulting.childcare.entity.Guardian;
import com.peoplesconsulting.childcare.service.GuardianService;

import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("/guardians")
public class GuardianController {

    @Autowired
    private GuardianService service;

    @GetMapping
    public List<Guardian> getAllGuardians() {
        return service.getAllGuardians();
    }

    @GetMapping("/{id}")
    public ResponseEntity<Guardian> getGuardianById(@PathVariable("id") Long id) {
        Optional<Guardian> guardian = service.getGuardianById(id);
        return guardian.map(value -> ResponseEntity.ok().body(value))
                .orElseGet(() -> ResponseEntity.notFound().build());
    }

    @PostMapping
    public ResponseEntity<Guardian> createGuardian(@RequestBody Guardian guardian) {
        Guardian createdGuardian = service.createGuardian(guardian);
        return ResponseEntity.status(HttpStatus.CREATED).body(createdGuardian);
    }

    @PutMapping("/{id}")
    public ResponseEntity<Guardian> updateGuardian(@PathVariable("id") Long id, @RequestBody Guardian guardian) {
        Guardian updatedGuardian = service.updateGuardian(id, guardian);
        return ResponseEntity.ok().body(updatedGuardian);
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Void> deleteGuardian(@PathVariable("id") Long id) {
        service.deleteGuardian(id);
        return ResponseEntity.noContent().build();
    }
}
