package com.peoplesconsulting.childcare.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.peoplesconsulting.childcare.entity.Address;

@Repository
public interface AddressRepository extends JpaRepository<Address, Long> {
}
