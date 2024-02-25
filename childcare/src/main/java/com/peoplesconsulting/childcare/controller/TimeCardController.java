package com.peoplesconsulting.childcare.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import com.peoplesconsulting.childcare.entity.TimeCard;
import com.peoplesconsulting.childcare.service.TimeCardService;

import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("/time-cards")
public class TimeCardController {

    @Autowired
    private TimeCardService service;

    @GetMapping
    public List<TimeCard> getAllTimeCards() {
        return service.getAllTimeCards();
    }

    @GetMapping("/{id}")
    public ResponseEntity<TimeCard> getTimeCardById(@PathVariable("id") Long id) {
        Optional<TimeCard> timeCard = service.getTimeCardById(id);
        return timeCard.map(value -> ResponseEntity.ok().body(value))
                .orElseGet(() -> ResponseEntity.notFound().build());
    }

    @PostMapping
    public ResponseEntity<TimeCard> createTimeCard(@RequestBody TimeCard timeCard) {
        TimeCard createdTimeCard = service.createTimeCard(timeCard);
        return ResponseEntity.status(HttpStatus.CREATED).body(createdTimeCard);
    }

    @PutMapping("/{id}")
    public ResponseEntity<TimeCard> updateTimeCard(@PathVariable("id") Long id, @RequestBody TimeCard timeCard) {
        TimeCard updatedTimeCard = service.updateTimeCard(id, timeCard);
        return ResponseEntity.ok().body(updatedTimeCard);
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Void> deleteTimeCard(@PathVariable("id") Long id) {
        service.deleteTimeCard(id);
        return ResponseEntity.noContent().build();
    }
}

