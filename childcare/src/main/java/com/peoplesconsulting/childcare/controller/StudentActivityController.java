package com.peoplesconsulting.childcare.controller;

import org.springframework.data.jpa.repository.JpaRepository;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import com.peoplesconsulting.childcare.entity.StudentActivity;
import com.peoplesconsulting.childcare.service.StudentActivityService;

import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("/student_activities")
public class StudentActivityController {

    @Autowired
    private StudentActivityService service;

    @GetMapping
    public List<StudentActivity> getAllStudentActivities() {
        return service.getAllStudentActivities();
    }

    @GetMapping("/{id}")
    public ResponseEntity<StudentActivity> getStudentActivityById(@PathVariable("id") Long id) {
        Optional<StudentActivity> studentActivity = service.getStudentActivityById(id);
        return studentActivity.map(value -> ResponseEntity.ok().body(value))
                .orElseGet(() -> ResponseEntity.notFound().build());
    }

    @PostMapping
    public ResponseEntity<StudentActivity> createStudentActivity(@RequestBody StudentActivity studentActivity) {
        StudentActivity createdStudentActivity = service.createStudentActivity(studentActivity);
        return ResponseEntity.status(HttpStatus.CREATED).body(createdStudentActivity);
    }

    @PutMapping("/{id}")
    public ResponseEntity<StudentActivity> updateStudentActivity(@PathVariable("id") Long id, @RequestBody StudentActivity studentActivity) {
        StudentActivity updatedStudentActivity = service.updateStudentActivity(id, studentActivity);
        return ResponseEntity.ok().body(updatedStudentActivity);
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Void> deleteStudentActivity(@PathVariable("id") Long id) {
        service.deleteStudentActivity(id);
        return ResponseEntity.noContent().build();
    }
}
