package com.peoplesconsulting.childcare.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.peoplesconsulting.childcare.entity.Guardian;
import com.peoplesconsulting.childcare.repository.GuardianRepository;

import java.util.List;
import java.util.Optional;

@Service
public class GuardianService {

    @Autowired
    private GuardianRepository repository;

    public List<Guardian> getAllGuardians() {
        return repository.findAll();
    }

    public Optional<Guardian> getGuardianById(Long id) {
        return repository.findById(id);
    }

    public Guardian createGuardian(Guardian guardian) {
        return repository.save(guardian);
    }

    public Guardian updateGuardian(Long id, Guardian guardian) {
        guardian.setGuardianId(id); // Ensure the correct ID is set
        return repository.save(guardian);
    }

    public void deleteGuardian(Long id) {
        repository.deleteById(id);
    }
}
