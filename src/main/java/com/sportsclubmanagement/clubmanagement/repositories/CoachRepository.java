package com.sportsclubmanagement.clubmanagement.repositories;

import com.sportsclubmanagement.clubmanagement.entity.Coach;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface CoachRepository extends JpaRepository<Coach, Long> {
}