package com.peoplesconsulting.childcare.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import com.peoplesconsulting.childcare.entity.ChildcareCenter;
import com.peoplesconsulting.childcare.service.ChildcareCenterService;

import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("/centers")
public class ChildcareCenterController {

    @Autowired
    private ChildcareCenterService service;

    @GetMapping
    public List<ChildcareCenter> getAllCenters() {
        return service.getAllCenters();
    }

    @GetMapping("/{id}")
    public ResponseEntity<ChildcareCenter> getCenterById(@PathVariable("id") Long id) {
        Optional<ChildcareCenter> center = service.getCenterById(id);
        return center.map(value -> ResponseEntity.ok().body(value))
                     .orElseGet(() -> ResponseEntity.notFound().build());
    }

    @PostMapping
    public ResponseEntity<ChildcareCenter> createCenter(@RequestBody ChildcareCenter center) {
        ChildcareCenter createdCenter = service.createCenter(center);
        return ResponseEntity.status(HttpStatus.CREATED).body(createdCenter);
    }

    @PutMapping("/{id}")
    public ResponseEntity<ChildcareCenter> updateCenter(@PathVariable("id") Long id, @RequestBody ChildcareCenter center) {
        ChildcareCenter updatedCenter = service.updateCenter(id, center);
        return ResponseEntity.ok().body(updatedCenter);
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Void> deleteCenter(@PathVariable("id") Long id) {
        service.deleteCenter(id);
        return ResponseEntity.noContent().build();
    }
}

