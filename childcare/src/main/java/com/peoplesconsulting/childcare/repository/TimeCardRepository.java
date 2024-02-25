package com.peoplesconsulting.childcare.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.peoplesconsulting.childcare.entity.TimeCard;

public interface TimeCardRepository extends JpaRepository<TimeCard, Long> {
}

