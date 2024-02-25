package com.peoplesconsulting.childcare.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.peoplesconsulting.childcare.entity.StudentHealthDetails;
import com.peoplesconsulting.childcare.repository.StudentHealthDetailsRepository;

import java.util.List;
import java.util.Optional;

@Service
public class StudentHealthDetailsService {

    @Autowired
    private StudentHealthDetailsRepository repository;

    public List<StudentHealthDetails> getAllStudentHealthDetails() {
        return repository.findAll();
    }

    public Optional<StudentHealthDetails> getStudentHealthDetailsById(Long id) {
        return repository.findById(id);
    }

    public StudentHealthDetails createStudentHealthDetails(StudentHealthDetails studentHealthDetails) {
        return repository.save(studentHealthDetails);
    }

    public StudentHealthDetails updateStudentHealthDetails(Long id, StudentHealthDetails studentHealthDetails) {
        studentHealthDetails.setHealthId(id);
        return repository.save(studentHealthDetails);
    }

    public void deleteStudentHealthDetails(Long id) {
        repository.deleteById(id);
    }
}

