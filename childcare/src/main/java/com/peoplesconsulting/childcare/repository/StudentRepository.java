package com.peoplesconsulting.childcare.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.peoplesconsulting.childcare.entity.Student;

public interface StudentRepository extends JpaRepository<Student, Long> {
}
