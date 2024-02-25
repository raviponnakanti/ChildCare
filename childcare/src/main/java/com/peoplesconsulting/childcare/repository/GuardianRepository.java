package com.peoplesconsulting.childcare.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.peoplesconsulting.childcare.entity.Guardian;

public interface GuardianRepository extends JpaRepository<Guardian, Long> {
}
