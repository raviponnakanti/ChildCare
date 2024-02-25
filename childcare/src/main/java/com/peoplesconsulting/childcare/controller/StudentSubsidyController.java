package com.peoplesconsulting.childcare.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import com.peoplesconsulting.childcare.entity.StudentSubsidy;
import com.peoplesconsulting.childcare.service.StudentSubsidyService;

import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("/student-subsidies")
public class StudentSubsidyController {

    @Autowired
    private StudentSubsidyService service;

    @GetMapping
    public List<StudentSubsidy> getAllStudentSubsidies() {
        return service.getAllStudentSubsidies();
    }

    @GetMapping("/{id}")
    public ResponseEntity<StudentSubsidy> getStudentSubsidyById(@PathVariable("id") Long id) {
        Optional<StudentSubsidy> studentSubsidy = service.getStudentSubsidyById(id);
        return studentSubsidy.map(value -> ResponseEntity.ok().body(value))
                .orElseGet(() -> ResponseEntity.notFound().build());
    }

    @PostMapping
    public ResponseEntity<StudentSubsidy> createStudentSubsidy(@RequestBody StudentSubsidy studentSubsidy) {
        StudentSubsidy createdStudentSubsidy = service.createStudentSubsidy(studentSubsidy);
        return ResponseEntity.status(HttpStatus.CREATED).body(createdStudentSubsidy);
    }

    @PutMapping("/{id}")
    public ResponseEntity<StudentSubsidy> updateStudentSubsidy(@PathVariable("id") Long id, @RequestBody StudentSubsidy studentSubsidy) {
        StudentSubsidy updatedStudentSubsidy = service.updateStudentSubsidy(id, studentSubsidy);
        return ResponseEntity.ok().body(updatedStudentSubsidy);
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Void> deleteStudentSubsidy(@PathVariable("id") Long id) {
        service.deleteStudentSubsidy(id);
        return ResponseEntity.noContent().build();
    }
}
