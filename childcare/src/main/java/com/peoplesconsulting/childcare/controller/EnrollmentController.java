package com.peoplesconsulting.childcare.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import com.peoplesconsulting.childcare.entity.Enrollment;
import com.peoplesconsulting.childcare.service.EnrollmentService;

import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("/enrollments")
public class EnrollmentController {

    @Autowired
    private EnrollmentService service;

    @GetMapping
    public List<Enrollment> getAllEnrollments() {
        return service.getAllEnrollments();
    }

    @GetMapping("/{id}")
    public ResponseEntity<Enrollment> getEnrollmentById(@PathVariable("id") Long id) {
        Optional<Enrollment> enrollment = service.getEnrollmentById(id);
        return enrollment.map(value -> ResponseEntity.ok().body(value))
                .orElseGet(() -> ResponseEntity.notFound().build());
    }

    @PostMapping
    public ResponseEntity<Enrollment> createEnrollment(@RequestBody Enrollment enrollment) {
        Enrollment createdEnrollment = service.createEnrollment(enrollment);
        return ResponseEntity.status(HttpStatus.CREATED).body(createdEnrollment);
    }

    @PutMapping("/{id}")
    public ResponseEntity<Enrollment> updateEnrollment(@PathVariable("id") Long id, @RequestBody Enrollment enrollment) {
        Enrollment updatedEnrollment = service.updateEnrollment(id, enrollment);
        return ResponseEntity.ok().body(updatedEnrollment);
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Void> deleteEnrollment(@PathVariable("id") Long id) {
        service.deleteEnrollment(id);
        return ResponseEntity.noContent().build();
    }
}
