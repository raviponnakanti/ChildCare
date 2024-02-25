package com.peoplesconsulting.childcare.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.peoplesconsulting.childcare.entity.Enrollment;
import com.peoplesconsulting.childcare.repository.EnrollmentRepository;

import java.util.List;
import java.util.Optional;

@Service
public class EnrollmentService {

    @Autowired
    private EnrollmentRepository repository;

    public List<Enrollment> getAllEnrollments() {
        return repository.findAll();
    }

    public Optional<Enrollment> getEnrollmentById(Long id) {
        return repository.findById(id);
    }

    public Enrollment createEnrollment(Enrollment enrollment) {
        return repository.save(enrollment);
    }

    public Enrollment updateEnrollment(Long id, Enrollment enrollment) {
        enrollment.setEnrollmentId(id); // Ensure the correct ID is set
        return repository.save(enrollment);
    }

    public void deleteEnrollment(Long id) {
        repository.deleteById(id);
    }
}

