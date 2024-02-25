package com.peoplesconsulting.childcare.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.peoplesconsulting.childcare.entity.Classroom;

public interface ClassroomRepository extends JpaRepository<Classroom, Long> {
}

