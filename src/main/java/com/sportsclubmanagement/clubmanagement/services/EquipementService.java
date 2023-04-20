package com.sportsclubmanagement.clubmanagement.services;

import com.sportsclubmanagement.clubmanagement.entity.Activity;
import com.sportsclubmanagement.clubmanagement.entity.Equipement;

import java.util.List;

public interface EquipementService {
    Equipement createEquipement(Equipement equipement);
    Equipement updateEquipement(Long id, Equipement equipement);
    void deleteEquipement(Long id);
    Equipement getEquipementById(Long id);
    List<Equipement> getAllEquipements();
}

