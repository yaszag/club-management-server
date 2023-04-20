package com.sportsclubmanagement.clubmanagement.controllers;

import com.sportsclubmanagement.clubmanagement.entity.Equipement;
import com.sportsclubmanagement.clubmanagement.services.EquipementService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/equipments")
public class EquipmentController {
    @Autowired
    private EquipementService equipmentService;

    // Endpoint for retrieving all equipments
    @GetMapping
    public List<Equipement> getAllEquipments() {
        return equipmentService.getAllEquipements();
    }

    // Endpoint for retrieving an equipment by ID
    @GetMapping("/{id}")
    public ResponseEntity<Equipement> getEquipmentById(@PathVariable Long id) {
        Equipement equipment = equipmentService.getEquipementById(id);
        if (equipment == null) {
            return ResponseEntity.notFound().build();
        } else {
            return ResponseEntity.ok(equipment);
        }
    }

    // Endpoint for creating a new equipment
    @PostMapping
    public ResponseEntity<Equipement> createEquipment(@RequestBody Equipement equipment) {
        Equipement createdEquipment = equipmentService.createEquipement(equipment);
        return ResponseEntity.status(HttpStatus.CREATED).body(createdEquipment);
    }

    // Endpoint for updating an equipment by ID
    @PutMapping("/{id}")
    public ResponseEntity<Equipement> updateEquipment(@PathVariable Long id, @RequestBody Equipement equipment) {
        Equipement updatedEquipment = equipmentService.updateEquipement(id, equipment);
        if (updatedEquipment == null) {
            return ResponseEntity.notFound().build();
        } else {
            return ResponseEntity.ok(updatedEquipment);
        }
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<?> delete(@PathVariable Long id) {
        equipmentService.deleteEquipement(id);
        return new ResponseEntity<>("Delete Success", HttpStatus.OK);
    }
}