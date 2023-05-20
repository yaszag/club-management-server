package com.sportsclubmanagement.clubmanagement.services.impl;

import com.sportsclubmanagement.clubmanagement.entity.Activity;
import com.sportsclubmanagement.clubmanagement.repositories.ActivityRepository;
import com.sportsclubmanagement.clubmanagement.services.ActivityService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class ActivityServiceImpl implements ActivityService {
    @Autowired
    private ActivityRepository activityRepository;

    @Override
    public Activity createActivity(Activity activity) {
        return activityRepository.save(activity);
    }

    @Override
    public Activity updateActivity(Long id, Activity activity) {
        if (activityRepository.findById(id).isPresent()) {
            activity.setId(id);
            return activityRepository.save(activity);
        }else {
            throw new IllegalArgumentException("Activity with ID " + id + " not found.");

        }

    }

    @Override
    public void deleteActivity(Long id) {
        Activity existingActivity = getActivityById(id);
        if (existingActivity == null) {
            throw new IllegalArgumentException("Activity with ID " + id + " not found.");
        }
        activityRepository.delete(existingActivity);
    }

    @Override
    public Activity getActivityById(Long id) {
        return activityRepository.findById(id).orElse(null);
    }

    @Override
    public List<Activity> getAllActivities() {
        return activityRepository.findAll();
    }

    @Override
    public List<Activity> getActivitiesByEquipementId(long equipementId) {
        return activityRepository.getActivitiesByEquipementsId(equipementId);
    }

    @Override
    public List<Activity> getActivitiesByIds(List<Long> activityIds) {
            return activityRepository.findAllById(activityIds);

    }


}
