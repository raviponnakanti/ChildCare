package com.peoplesconsulting.childcare.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.peoplesconsulting.childcare.entity.Medications;
import com.peoplesconsulting.childcare.repository.MedicationsRepository;

import java.util.List;
import java.util.Optional;

@Service
public class MedicationsService {

    @Autowired
    private MedicationsRepository repository;

    public List<Medications> getAllMedications() {
        return repository.findAll();
    }

    public Optional<Medications> getMedicationsById(Long id) {
        return repository.findById(id);
    }

    public Medications createMedications(Medications medications) {
        return repository.save(medications);
    }

    public Medications updateMedications(Long id, Medications medications) {
        medications.setMedicationId(id); // Ensure the correct ID is set
        return repository.save(medications);
    }

    public void deleteMedications(Long id) {
        repository.deleteById(id);
    }
}

