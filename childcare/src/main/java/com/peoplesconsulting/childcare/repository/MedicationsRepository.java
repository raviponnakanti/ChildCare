package com.peoplesconsulting.childcare.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.peoplesconsulting.childcare.entity.Medications;

public interface MedicationsRepository extends JpaRepository<Medications, Long> {
}

