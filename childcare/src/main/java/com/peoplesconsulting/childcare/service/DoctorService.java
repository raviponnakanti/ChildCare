package com.peoplesconsulting.childcare.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.peoplesconsulting.childcare.entity.Doctor;
import com.peoplesconsulting.childcare.repository.DoctorRepository;

import java.util.List;
import java.util.Optional;

@Service
public class DoctorService {

    @Autowired
    private DoctorRepository repository;

    public List<Doctor> getAllDoctors() {
        return repository.findAll();
    }

    public Optional<Doctor> getDoctorById(Long id) {
        return repository.findById(id);
    }

    public Doctor createDoctor(Doctor doctor) {
        return repository.save(doctor);
    }

    public Doctor updateDoctor(Long id, Doctor doctor) {
        doctor.setDoctorId(id); // Ensure the correct ID is set
        return repository.save(doctor);
    }

    public void deleteDoctor(Long id) {
        repository.deleteById(id);
    }
}
