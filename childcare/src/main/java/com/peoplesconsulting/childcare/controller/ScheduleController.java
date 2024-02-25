package com.peoplesconsulting.childcare.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import com.peoplesconsulting.childcare.entity.Schedule;
import com.peoplesconsulting.childcare.service.ScheduleService;

import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("/schedules")
public class ScheduleController {

    @Autowired
    private ScheduleService service;

    @GetMapping
    public List<Schedule> getAllSchedules() {
        return service.getAllSchedules();
    }

    @GetMapping("/{id}")
    public ResponseEntity<Schedule> getScheduleById(@PathVariable("id") Long id) {
        Optional<Schedule> schedule = service.getScheduleById(id);
        return schedule.map(value -> ResponseEntity.ok().body(value))
                .orElseGet(() -> ResponseEntity.notFound().build());
    }

    @PostMapping
    public ResponseEntity<Schedule> createSchedule(@RequestBody Schedule schedule) {
        Schedule createdSchedule = service.createSchedule(schedule);
        return ResponseEntity.status(HttpStatus.CREATED).body(createdSchedule);
    }

    @PutMapping("/{id}")
    public ResponseEntity<Schedule> updateSchedule(@PathVariable("id") Long id, @RequestBody Schedule schedule) {
        Schedule updatedSchedule = service.updateSchedule(id, schedule);
        return ResponseEntity.ok().body(updatedSchedule);
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Void> deleteSchedule(@PathVariable("id") Long id) {
        service.deleteSchedule(id);
        return ResponseEntity.noContent().build();
    }
}
