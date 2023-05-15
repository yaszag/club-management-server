package com.sportsclubmanagement.clubmanagement.services;

import com.sportsclubmanagement.clubmanagement.entity.Activity;


import java.util.List;

public interface ActivityService {
    Activity createActivity(Activity activity);
    Activity updateActivity(Long id, Activity activity);
    void deleteActivity(Long id);
    Activity getActivityById(Long id);
    List<Activity> getAllActivities();
    List<Activity> getActivitiesByCoachId(long coachId);
    List<Activity> getActivitiesByEquipementId(long equipementId);
    List<Activity> getActivitiesByIds(List<Long> activityIds);


}