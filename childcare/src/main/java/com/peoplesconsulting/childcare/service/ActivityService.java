package com.peoplesconsulting.childcare.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.peoplesconsulting.childcare.entity.Activity;
import com.peoplesconsulting.childcare.repository.ActivityRepository;

import java.util.List;
import java.util.Optional;

@Service
public class ActivityService {

    @Autowired
    private ActivityRepository repository;

    public List<Activity> getAllActivities() {
        return repository.findAll();
    }

    public Optional<Activity> getActivityById(Long id) {
        return repository.findById(id);
    }

    public Activity createActivity(Activity activity) {
        return repository.save(activity);
    }

    public Activity updateActivity(Long id, Activity activity) {
        activity.setActivityId(id); // Ensure the correct ID is set
        return repository.save(activity);
    }

    public void deleteActivity(Long id) {
        repository.deleteById(id);
    }
}
