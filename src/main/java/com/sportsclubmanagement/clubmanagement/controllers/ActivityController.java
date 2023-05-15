package com.sportsclubmanagement.clubmanagement.controllers;

import com.sportsclubmanagement.clubmanagement.entity.Activity;
import com.sportsclubmanagement.clubmanagement.services.ActivityService;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@Api(value = "Activity Management")
@RestController
@RequestMapping("/activities")
public class ActivityController {
    @Autowired
    private ActivityService activityService;

    // Endpoint for retrieving all activities
    @ApiOperation(value = "Get All Activities")
    @GetMapping
    public List<Activity> getAllActivities() {
        return activityService.getAllActivities();
    }

    // Endpoint for retrieving an activity by ID
    @ApiOperation(value = "Get Activity By Id")
    @GetMapping("/{id}")
    public ResponseEntity<Activity> getActivityById(@PathVariable Long id) {
        Activity activity = activityService.getActivityById(id);
        if (activity == null) {
            return ResponseEntity.notFound().build();
        } else {
            return ResponseEntity.ok(activity);
        }
    }

    // Endpoint for creating a new activity
    @ApiOperation(value = "Create Activity")
    @PostMapping
    public ResponseEntity<Activity> createActivity(@RequestBody Activity activity) {
        Activity createdActivity = activityService.createActivity(activity);
        return ResponseEntity.status(HttpStatus.CREATED).body(createdActivity);
    }

    // Endpoint for updating an activity by ID
    @PutMapping("/{id}")
    @ApiOperation(value = "Update Activity")
    public ResponseEntity<Activity> updateActivity(@PathVariable Long id, @RequestBody Activity activity) {
        Activity updatedActivity = activityService.updateActivity(id, activity);
        if (updatedActivity == null) {
            return ResponseEntity.notFound().build();
        } else {
            return ResponseEntity.ok(updatedActivity);
        }
    }

    // Endpoint for deleting an activity by ID


    // Endpoint for retrieving activities by coach ID
    @ApiOperation(value = "Get Activities By Coach Id")
    @GetMapping("/by-coach/{coachId}")
    public List<Activity> getActivitiesByCoachId(@PathVariable Long coachId) {
        return activityService.getActivitiesByCoachId(coachId);
    }

    // Endpoint for retrieving activities by member ID
    // @ApiOperation(value = "Get Member By Coach Id")
    //@GetMapping("/by-member/{memberId}")
    //public List<Activity> getActivitiesByMemberId(@PathVariable Long memberId) {
    //  return activityService.getActivitiesByMemberId(memberId);
    //}

    // Endpoint for retrieving activities by equipment ID
    @ApiOperation(value = "Get Activities By Equipment Id")
    @GetMapping("/by-equipment/{equipmentId}")
    public List<Activity> getActivitiesByEquipmentId(@PathVariable Long equipmentId) {
        return activityService.getActivitiesByEquipementId(equipmentId);
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<?> delete(@PathVariable Long id) {
        activityService.deleteActivity(id);
        return new ResponseEntity<>("Delete Success", HttpStatus.OK);
    }
}

