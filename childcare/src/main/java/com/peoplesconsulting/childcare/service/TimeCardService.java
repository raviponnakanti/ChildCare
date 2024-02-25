package com.peoplesconsulting.childcare.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.peoplesconsulting.childcare.entity.TimeCard;
import com.peoplesconsulting.childcare.repository.TimeCardRepository;

import java.util.List;
import java.util.Optional;

@Service
public class TimeCardService {

    @Autowired
    private TimeCardRepository repository;

    public List<TimeCard> getAllTimeCards() {
        return repository.findAll();
    }

    public Optional<TimeCard> getTimeCardById(Long id) {
        return repository.findById(id);
    }

    public TimeCard createTimeCard(TimeCard timeCard) {
        return repository.save(timeCard);
    }

    public TimeCard updateTimeCard(Long id, TimeCard timeCard) {
        timeCard.setTimeCardId(id); // Ensure the correct ID is set
        return repository.save(timeCard);
    }

    public void deleteTimeCard(Long id) {
        repository.deleteById(id);
    }
}

