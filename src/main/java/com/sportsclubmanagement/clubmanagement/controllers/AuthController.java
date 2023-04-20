package com.sportsclubmanagement.clubmanagement.controllers;

import com.sportsclubmanagement.clubmanagement.entity.Admin;
import com.sportsclubmanagement.clubmanagement.entity.DTO.LoginRequest;
import com.sportsclubmanagement.clubmanagement.entity.DTO.SignUpRequest;
import com.sportsclubmanagement.clubmanagement.services.AdminService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/api/auth")
public class AuthController {

    private final AdminService adminService;

    @Autowired
    public AuthController(AdminService adminService) {
        this.adminService = adminService;
    }

    @PostMapping("/signin")
    public ResponseEntity<?> authenticateUser(@RequestBody LoginRequest loginRequest) {
        return ResponseEntity.ok(adminService.Authenticate(loginRequest));
    }

    @PostMapping("/signup")
    public ResponseEntity<?> register(@RequestBody SignUpRequest signUpRequest) {

        Admin admin = new Admin(signUpRequest.getUsername(), signUpRequest.getPassword());
        return ResponseEntity.ok(adminService.AddAdmin(admin));
    }
}

