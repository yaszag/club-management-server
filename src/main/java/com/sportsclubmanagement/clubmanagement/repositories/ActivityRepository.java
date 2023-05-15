package com.sportsclubmanagement.clubmanagement.repositories;

import com.sportsclubmanagement.clubmanagement.entity.Activity;
import com.sportsclubmanagement.clubmanagement.entity.Coach;
import com.sportsclubmanagement.clubmanagement.entity.Equipement;
import com.sportsclubmanagement.clubmanagement.entity.Member;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface ActivityRepository extends JpaRepository<Activity, Long> {
    List<Activity> getActivitiesByCoachesId(long coachId);
    List<Activity> getActivitiesByEquipementsId(long equipementId);
}
