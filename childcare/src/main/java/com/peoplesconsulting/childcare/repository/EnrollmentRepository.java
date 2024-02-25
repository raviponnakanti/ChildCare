package com.peoplesconsulting.childcare.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.peoplesconsulting.childcare.entity.Enrollment;

public interface EnrollmentRepository extends JpaRepository<Enrollment, Long> {
}

