package com.sportsclubmanagement.clubmanagement.repositories;

import com.sportsclubmanagement.clubmanagement.entity.Equipement;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface EquipementRepository extends JpaRepository<Equipement, Long> {
}