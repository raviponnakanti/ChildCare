package com.peoplesconsulting.childcare.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.peoplesconsulting.childcare.entity.Schedule;
import com.peoplesconsulting.childcare.repository.ScheduleRepository;

import java.util.List;
import java.util.Optional;

@Service
public class ScheduleService {

    @Autowired
    private ScheduleRepository repository;

    public List<Schedule> getAllSchedules() {
        return repository.findAll();
    }

    public Optional<Schedule> getScheduleById(Long id) {
        return repository.findById(id);
    }

    public Schedule createSchedule(Schedule schedule) {
        return repository.save(schedule);
    }

    public Schedule updateSchedule(Long id, Schedule schedule) {
        schedule.setScheduleId(id); // Ensure the correct ID is set
        return repository.save(schedule);
    }

    public void deleteSchedule(Long id) {
        repository.deleteById(id);
    }
}
