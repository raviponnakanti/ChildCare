package com.peoplesconsulting.childcare.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.peoplesconsulting.childcare.entity.Activity;

public interface ActivityRepository extends JpaRepository<Activity, Long> {
}
