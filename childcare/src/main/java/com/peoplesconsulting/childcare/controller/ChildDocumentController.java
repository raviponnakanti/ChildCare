package com.peoplesconsulting.childcare.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import com.peoplesconsulting.childcare.entity.ChildDocument;
import com.peoplesconsulting.childcare.service.ChildDocumentService;

import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("/child-documents")
public class ChildDocumentController {
//
//    @Autowired
//    private ChildDocumentService service;
//
//    @GetMapping
//    public List<ChildDocument> getAllChildDocuments() {
//        return service.getAllChildDocuments();
//    }
//
//    @GetMapping("/{id}")
//    public ResponseEntity<ChildDocument> getChildDocumentById(@PathVariable("id") Long id) {
//        Optional<ChildDocument> childDocument = service.getChildDocumentById(id);
//        return childDocument.map(value -> ResponseEntity.ok().body(value))
//                .orElseGet(() -> ResponseEntity.notFound().build());
//    }
//
//    @PostMapping
//    public ResponseEntity<ChildDocument> createChildDocument(@RequestBody ChildDocument childDocument) {
//        ChildDocument createdChildDocument = service.createChildDocument(childDocument);
//        return ResponseEntity.status(HttpStatus.CREATED).body(createdChildDocument);
//    }
//
//    @PutMapping("/{id}")
//    public ResponseEntity<ChildDocument> updateChildDocument(@PathVariable("id") Long id, @RequestBody ChildDocument childDocument) {
//        ChildDocument updatedChildDocument = service.updateChildDocument(id, childDocument);
//        return ResponseEntity.ok().body(updatedChildDocument);
//    }
//
//    @DeleteMapping("/{id}")
//    public ResponseEntity<Void> deleteChildDocument(@PathVariable("id") Long id) {
//        service.deleteChildDocument(id);
//        return ResponseEntity.noContent().build();
//    }
}
