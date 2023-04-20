package com.sportsclubmanagement.clubmanagement.controllers;

import com.sportsclubmanagement.clubmanagement.services.AdminService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/api/admin")
public class AdminController {

    private final AdminService adminService;

    @Autowired
    public AdminController(AdminService adminService) {
        this.adminService = adminService;
    }

    @GetMapping("/")
    public ResponseEntity<?> getByUserName(@RequestParam(value = "username") String username) {

        return new ResponseEntity<>(adminService.FindAdminByUsername(username), HttpStatus.OK);
    }
}
