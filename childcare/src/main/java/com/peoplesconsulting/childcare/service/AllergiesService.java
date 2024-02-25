package com.peoplesconsulting.childcare.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.peoplesconsulting.childcare.entity.Allergies;
import com.peoplesconsulting.childcare.repository.AllergiesRepository;

import java.util.List;
import java.util.Optional;

@Service
public class AllergiesService {

    @Autowired
    private AllergiesRepository repository;

    public List<Allergies> getAllAllergies() {
        return repository.findAll();
    }

    public Optional<Allergies> getAllergiesById(Long id) {
        return repository.findById(id);
    }

    public Allergies createAllergies(Allergies allergies) {
        return repository.save(allergies);
    }

    public Allergies updateAllergies(Long id, Allergies allergies) {
        allergies.setAllergyId(id); // Ensure the correct ID is set
        return repository.save(allergies);
    }

    public void deleteAllergies(Long id) {
        repository.deleteById(id);
    }
}

