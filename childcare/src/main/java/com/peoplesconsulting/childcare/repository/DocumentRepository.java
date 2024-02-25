package com.peoplesconsulting.childcare.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.peoplesconsulting.childcare.entity.Document;

public interface DocumentRepository extends JpaRepository<Document, Long> {
}
