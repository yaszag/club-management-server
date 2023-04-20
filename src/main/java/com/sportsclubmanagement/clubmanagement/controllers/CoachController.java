package com.sportsclubmanagement.clubmanagement.controllers;

import com.sportsclubmanagement.clubmanagement.entity.Coach;
import com.sportsclubmanagement.clubmanagement.services.CoachService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/coaches")
public class CoachController {
    @Autowired
    private CoachService coachService;

    // Endpoint for retrieving all coaches
    @GetMapping
    public List<Coach> getAllCoaches() {
        return coachService.getAllCoaches();
    }

    // Endpoint for retrieving a coach by ID
    @GetMapping("/{id}")
    public ResponseEntity<Coach> getCoachById(@PathVariable Long id) {
        Coach coach = coachService.getCoachById(id);
        if (coach == null) {
            return ResponseEntity.notFound().build();
        } else {
            return ResponseEntity.ok(coach);
        }
    }

    // Endpoint for creating a new coach
    @PostMapping
    public ResponseEntity<Coach> createCoach(@RequestBody Coach coach) {
        Coach createdCoach = coachService.createCoach(coach);
        return ResponseEntity.status(HttpStatus.CREATED).body(createdCoach);
    }

    // Endpoint for updating a coach by ID
    @PutMapping("/{id}")
    public ResponseEntity<Coach> updateCoach(@PathVariable Long id, @RequestBody Coach coach) {
        Coach updatedCoach = coachService.updateCoach(id, coach);
        if (updatedCoach == null) {
            return ResponseEntity.notFound().build();
        } else {
            return ResponseEntity.ok(updatedCoach);
        }
    }

    // Endpoint for deleting a coach by ID
    @DeleteMapping("/{id}")
    public ResponseEntity<?> delete(@PathVariable Long id) {
        coachService.deleteCoach(id);
        return new ResponseEntity<>("Delete Success", HttpStatus.OK);
    }
}

