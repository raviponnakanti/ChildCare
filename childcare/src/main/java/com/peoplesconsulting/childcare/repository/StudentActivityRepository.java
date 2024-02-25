package com.peoplesconsulting.childcare.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.peoplesconsulting.childcare.entity.StudentActivity;

public interface StudentActivityRepository extends JpaRepository<StudentActivity, Long> {
}
