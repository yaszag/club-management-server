package com.sportsclubmanagement.clubmanagement.services.impl;

import com.sportsclubmanagement.clubmanagement.entity.Activity;
import com.sportsclubmanagement.clubmanagement.entity.Equipement;
import com.sportsclubmanagement.clubmanagement.repositories.EquipementRepository;
import com.sportsclubmanagement.clubmanagement.services.EquipementService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class EquipementServiceImpl implements EquipementService {
    @Autowired
    private EquipementRepository equipementRepository;

    @Override
    public Equipement createEquipement(Equipement equipement) {
        return equipementRepository.save(equipement);
    }

    @Override
    public Equipement updateEquipement(Long id, Equipement equipement) {
        Equipement existingEquipement = getEquipementById(id);
        if (existingEquipement == null) {
            throw new IllegalArgumentException("Equipement with ID " + id + " not found.");
        }
        return equipementRepository.save(equipement);
    }

    @Override
    public void deleteEquipement(Long id) {
        Equipement existingEquipement = getEquipementById(id);
        if (existingEquipement == null) {
            throw new IllegalArgumentException("Equipement with ID " + id + " not found.");
        }
        equipementRepository.delete(existingEquipement);
    }

    @Override
    public Equipement getEquipementById(Long id) {
        return equipementRepository.findById(id).orElse(null);
    }

    @Override
    public List<Equipement> getAllEquipements() {
        return equipementRepository.findAll();
    }


}

