package com.peoplesconsulting.childcare.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.peoplesconsulting.childcare.entity.StudentSubsidy;
import com.peoplesconsulting.childcare.repository.StudentSubsidyRepository;

import java.util.List;
import java.util.Optional;

@Service
public class StudentSubsidyService {

    @Autowired
    private StudentSubsidyRepository repository;

    public List<StudentSubsidy> getAllStudentSubsidies() {
        return repository.findAll();
    }

    public Optional<StudentSubsidy> getStudentSubsidyById(Long id) {
        return repository.findById(id);
    }

    public StudentSubsidy createStudentSubsidy(StudentSubsidy studentSubsidy) {
        return repository.save(studentSubsidy);
    }

    public StudentSubsidy updateStudentSubsidy(Long id, StudentSubsidy studentSubsidy) {
        studentSubsidy.setSubsidyId(id); // Ensure the correct ID is set
        return repository.save(studentSubsidy);
    }

    public void deleteStudentSubsidy(Long id) {
        repository.deleteById(id);
    }
}
