package com.peoplesconsulting.childcare.service;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.peoplesconsulting.childcare.entity.Document;
import com.peoplesconsulting.childcare.repository.DocumentRepository;

import java.util.List;
import java.util.Optional;

@Service
public class DocumentService {

    @Autowired
    private DocumentRepository repository;

    public List<Document> getAllDocuments() {
        return repository.findAll();
    }

    public Optional<Document> getDocumentById(Long id) {
        return repository.findById(id);
    }

    public Document createDocument(Document document) {
        return repository.save(document);
    }

    public Document updateDocument(Long id, Document document) {
        document.setDocumentId(id); // Ensure the correct ID is set
        return repository.save(document);
    }

    public void deleteDocument(Long id) {
        repository.deleteById(id);
    }
}
