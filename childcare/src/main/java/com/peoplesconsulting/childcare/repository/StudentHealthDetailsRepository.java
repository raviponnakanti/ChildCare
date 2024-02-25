package com.peoplesconsulting.childcare.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.peoplesconsulting.childcare.entity.StudentHealthDetails;

public interface StudentHealthDetailsRepository extends JpaRepository<StudentHealthDetails, Long> {
}

