package com.sportsclubmanagement.clubmanagement.services;

import com.sportsclubmanagement.clubmanagement.entity.Activity;
import com.sportsclubmanagement.clubmanagement.entity.Coach;

import java.util.List;

public interface CoachService {
    Coach createCoach(Coach coach);
    Coach updateCoach(Long id, Coach coach);
    void deleteCoach(Long id);
    Coach getCoachById(Long id);
    List<Coach> getAllCoaches();
}
