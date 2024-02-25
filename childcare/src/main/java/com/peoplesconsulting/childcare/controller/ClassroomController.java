package com.peoplesconsulting.childcare.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import com.peoplesconsulting.childcare.entity.Classroom;
import com.peoplesconsulting.childcare.service.ClassroomService;

import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("/classrooms")
public class ClassroomController {

    @Autowired
    private ClassroomService service;

    @GetMapping
    public List<Classroom> getAllClassrooms() {
        return service.getAllClassrooms();
    }

    @GetMapping("/{id}")
    public ResponseEntity<Classroom> getClassroomById(@PathVariable("id") Long id) {
        Optional<Classroom> classroom = service.getClassroomById(id);
        return classroom.map(value -> ResponseEntity.ok().body(value))
                        .orElseGet(() -> ResponseEntity.notFound().build());
    }

    @PostMapping
    public ResponseEntity<Classroom> createClassroom(@RequestBody Classroom classroom) {
        Classroom createdClassroom = service.createClassroom(classroom);
        return ResponseEntity.status(HttpStatus.CREATED).body(createdClassroom);
    }

    @PutMapping("/{id}")
    public ResponseEntity<Classroom> updateClassroom(@PathVariable("id") Long id, @RequestBody Classroom classroom) {
        Classroom updatedClassroom = service.updateClassroom(id, classroom);
        return ResponseEntity.ok().body(updatedClassroom);
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Void> deleteClassroom(@PathVariable("id") Long id) {
        service.deleteClassroom(id);
        return ResponseEntity.noContent().build();
    }
}
