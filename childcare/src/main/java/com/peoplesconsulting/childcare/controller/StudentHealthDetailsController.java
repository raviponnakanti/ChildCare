package com.peoplesconsulting.childcare.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import com.peoplesconsulting.childcare.entity.StudentHealthDetails;
import com.peoplesconsulting.childcare.service.StudentHealthDetailsService;

import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("/student-health-details")
public class StudentHealthDetailsController {

    @Autowired
    private StudentHealthDetailsService service;

    @GetMapping
    public List<StudentHealthDetails> getAllStudentHealthDetails() {
        return service.getAllStudentHealthDetails();
    }

    @GetMapping("/{id}")
    public ResponseEntity<StudentHealthDetails> getStudentHealthDetailsById(@PathVariable("id") Long id) {
        Optional<StudentHealthDetails> studentHealthDetails = service.getStudentHealthDetailsById(id);
        return studentHealthDetails.map(value -> ResponseEntity.ok().body(value))
                .orElseGet(() -> ResponseEntity.notFound().build());
    }

    @PostMapping
    public ResponseEntity<StudentHealthDetails> createStudentHealthDetails(@RequestBody StudentHealthDetails studentHealthDetails) {
        StudentHealthDetails createdStudentHealthDetails = service.createStudentHealthDetails(studentHealthDetails);
        return ResponseEntity.status(HttpStatus.CREATED).body(createdStudentHealthDetails);
    }

    @PutMapping("/{id}")
    public ResponseEntity<StudentHealthDetails> updateStudentHealthDetails(@PathVariable("id") Long id, @RequestBody StudentHealthDetails studentHealthDetails) {
        StudentHealthDetails updatedStudentHealthDetails = service.updateStudentHealthDetails(id, studentHealthDetails);
        return ResponseEntity.ok().body(updatedStudentHealthDetails);
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Void> deleteStudentHealthDetails(@PathVariable("id") Long id) {
        service.deleteStudentHealthDetails(id);
        return ResponseEntity.noContent().build();
    }
}
