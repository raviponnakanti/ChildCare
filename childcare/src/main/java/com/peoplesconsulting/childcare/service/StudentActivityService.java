package com.peoplesconsulting.childcare.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.peoplesconsulting.childcare.entity.StudentActivity;
import com.peoplesconsulting.childcare.repository.StudentActivityRepository;

import java.util.List;
import java.util.Optional;

@Service
public class StudentActivityService {

    @Autowired
    private StudentActivityRepository repository;

    public List<StudentActivity> getAllStudentActivities() {
        return repository.findAll();
    }

    public Optional<StudentActivity> getStudentActivityById(Long id) {
        return repository.findById(id);
    }

    public StudentActivity createStudentActivity(StudentActivity studentActivity) {
        return repository.save(studentActivity);
    }

    public StudentActivity updateStudentActivity(Long id, StudentActivity studentActivity) {
        studentActivity.setStudentActivityId(id); // Ensure the correct ID is set
        return repository.save(studentActivity);
    }

    public void deleteStudentActivity(Long id) {
        repository.deleteById(id);
    }
}
