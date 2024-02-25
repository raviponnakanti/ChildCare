package com.peoplesconsulting.childcare.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.peoplesconsulting.childcare.entity.Classroom;
import com.peoplesconsulting.childcare.repository.ClassroomRepository;

import java.util.List;
import java.util.Optional;

@Service
public class ClassroomService {

    @Autowired
    private ClassroomRepository repository;

    public List<Classroom> getAllClassrooms() {
        return repository.findAll();
    }

    public Optional<Classroom> getClassroomById(Long id) {
        return repository.findById(id);
    }

    public Classroom createClassroom(Classroom classroom) {
        return repository.save(classroom);
    }

    public Classroom updateClassroom(Long id, Classroom classroom) {
        classroom.setClassroomId(id); // Ensure the correct ID is set
        return repository.save(classroom);
    }

    public void deleteClassroom(Long id) {
        repository.deleteById(id);
    }
}