package com.sportsclubmanagement.clubmanagement.services.impl;

import com.sportsclubmanagement.clubmanagement.entity.Activity;
import com.sportsclubmanagement.clubmanagement.entity.Coach;
import com.sportsclubmanagement.clubmanagement.repositories.CoachRepository;
import com.sportsclubmanagement.clubmanagement.services.CoachService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class CoachServiceImpl implements CoachService {
    @Autowired
    private CoachRepository coachRepository;

    @Override
    public Coach createCoach(Coach coach) {
        return coachRepository.save(coach);
    }

    @Override
    public Coach updateCoach(Long id, Coach coach) {
        Coach existingCoach = getCoachById(id);
        if (existingCoach == null) {
            throw new IllegalArgumentException("Coach with ID " + id + " not found.");
        }
        return coachRepository.save(coach);
    }

    @Override
    public void deleteCoach(Long id) {
        Coach existingCoach = getCoachById(id);
        if (existingCoach == null) {
            throw new IllegalArgumentException("Coach with ID " + id + " not found.");
        }
        coachRepository.delete(existingCoach);
    }

    @Override
    public Coach getCoachById(Long id) {
        return coachRepository.findById(id).orElse(null);
    }

    @Override
    public List<Coach> getAllCoaches() {
        return coachRepository.findAll();
    }


}

