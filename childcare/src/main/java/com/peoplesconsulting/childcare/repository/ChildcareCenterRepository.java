package com.peoplesconsulting.childcare.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.peoplesconsulting.childcare.entity.ChildcareCenter;

@Repository
public interface ChildcareCenterRepository extends JpaRepository<ChildcareCenter, Long> {
}
