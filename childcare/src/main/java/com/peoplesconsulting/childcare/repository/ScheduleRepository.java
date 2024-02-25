package com.peoplesconsulting.childcare.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.peoplesconsulting.childcare.entity.Schedule;

public interface ScheduleRepository extends JpaRepository<Schedule, Long> {
}

