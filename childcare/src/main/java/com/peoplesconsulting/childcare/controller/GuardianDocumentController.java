package com.peoplesconsulting.childcare.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import com.peoplesconsulting.childcare.entity.GuardianDocument;
import com.peoplesconsulting.childcare.service.GuardianDocumentService;

import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("/guardian-documents")
public class GuardianDocumentController {
//
//    @Autowired
//    private GuardianDocumentService service;
//
//    @GetMapping
//    public List<GuardianDocument> getAllGuardianDocuments() {
//        return service.getAllGuardianDocuments();
//    }
//
//    @GetMapping("/{id}")
//    public ResponseEntity<GuardianDocument> getGuardianDocumentById(@PathVariable("id") Long id) {
//        Optional<GuardianDocument> guardianDocument = service.getGuardianDocumentById(id);
//        return guardianDocument.map(value -> ResponseEntity.ok().body(value))
//                .orElseGet(() -> ResponseEntity.notFound().build());
//    }
//
//    @PostMapping
//    public ResponseEntity<GuardianDocument> createGuardianDocument(@RequestBody GuardianDocument guardianDocument) {
//        GuardianDocument createdGuardianDocument = service.createGuardianDocument(guardianDocument);
//        return ResponseEntity.status(HttpStatus.CREATED).body(createdGuardianDocument);
//    }
//
//    @PutMapping("/{id}")
//    public ResponseEntity<GuardianDocument> updateGuardianDocument(@PathVariable("id") Long id, @RequestBody GuardianDocument guardianDocument) {
//        GuardianDocument updatedGuardianDocument = service.updateGuardianDocument(id, guardianDocument);
//        return ResponseEntity.ok().body(updatedGuardianDocument);
//    }
//
//    @DeleteMapping("/{id}")
//    public ResponseEntity<Void> deleteGuardianDocument(@PathVariable("id") Long id) {
//        service.deleteGuardianDocument(id);
//        return ResponseEntity.noContent().build();
//    }
}
