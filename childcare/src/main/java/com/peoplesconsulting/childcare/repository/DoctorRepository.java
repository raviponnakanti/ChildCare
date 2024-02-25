package com.peoplesconsulting.childcare.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.peoplesconsulting.childcare.entity.Doctor;

public interface DoctorRepository extends JpaRepository<Doctor, Long> {
}

