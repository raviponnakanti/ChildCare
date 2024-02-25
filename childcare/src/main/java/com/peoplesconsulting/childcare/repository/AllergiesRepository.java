package com.peoplesconsulting.childcare.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.peoplesconsulting.childcare.entity.Allergies;

public interface AllergiesRepository extends JpaRepository<Allergies, Long> {
}
