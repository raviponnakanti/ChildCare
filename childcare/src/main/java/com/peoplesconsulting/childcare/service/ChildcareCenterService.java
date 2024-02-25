package com.peoplesconsulting.childcare.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.peoplesconsulting.childcare.entity.ChildcareCenter;
import com.peoplesconsulting.childcare.repository.ChildcareCenterRepository;

import java.util.List;
import java.util.Optional;

@Service
public class ChildcareCenterService {

    @Autowired
    private ChildcareCenterRepository repository;

    public List<ChildcareCenter> getAllCenters() {
        return repository.findAll();
    }

    public Optional<ChildcareCenter> getCenterById(Long id) {
        return repository.findById(id);
    }

    public ChildcareCenter createCenter(ChildcareCenter center) {
        return repository.save(center);
    }

    public ChildcareCenter updateCenter(Long id, ChildcareCenter center) {
        center.setCenterId(id); // Ensure the correct ID is set
        return repository.save(center);
    }

    public void deleteCenter(Long id) {
        repository.deleteById(id);
    }
}
