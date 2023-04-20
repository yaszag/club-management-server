package com.sportsclubmanagement.clubmanagement.services.impl;


import com.sportsclubmanagement.clubmanagement.Utils.JWTutils;
import com.sportsclubmanagement.clubmanagement.Utils.UserDetailsImpl;
import com.sportsclubmanagement.clubmanagement.entity.Admin;
import com.sportsclubmanagement.clubmanagement.entity.DTO.JwtResponse;
import com.sportsclubmanagement.clubmanagement.entity.DTO.LoginRequest;
import com.sportsclubmanagement.clubmanagement.exeptions.ConflictException;
import com.sportsclubmanagement.clubmanagement.exeptions.NotFoundException;
import com.sportsclubmanagement.clubmanagement.exeptions.UnauthorizeddException;
import com.sportsclubmanagement.clubmanagement.repositories.AdminRepository;
import com.sportsclubmanagement.clubmanagement.services.AdminService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.BadCredentialsException;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.Authentication;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class AdminServiceImpl implements AdminService {

    private final AdminRepository adminRepository;
    private final AuthenticationManager authenticationManager;
    private final JWTutils jwtUtils;

    @Autowired
    public AdminServiceImpl(AdminRepository adminRepository, AuthenticationManager authenticationManager, JWTutils jwtUtils) {
        this.adminRepository = adminRepository;
        this.authenticationManager = authenticationManager;
        this.jwtUtils = jwtUtils;
    }

    @Override
    public JwtResponse Authenticate(LoginRequest loginRequest) {
        Authentication authentication;
        try {
            authentication = authenticationManager.authenticate(
                    new UsernamePasswordAuthenticationToken(loginRequest.getUsername(), loginRequest.getPassword()));

        } catch (BadCredentialsException e) {
            throw new UnauthorizeddException("Invalid email/password supplied!");
        }

        String jwt = jwtUtils.generateJwtToken(authentication);
        UserDetailsImpl userDetails = (UserDetailsImpl) authentication.getPrincipal();

        return new JwtResponse(
                userDetails.getId(),
                jwt,
                userDetails.getUsername());
    }

    @Override
    public Admin AddAdmin(Admin admin) {
        if (adminRepository.existsByUsername(admin.getUsername())) {
            throw new ConflictException("UserName is already in use!");
        }

        admin.setPassword(new BCryptPasswordEncoder().encode(admin.getPassword()));
        return adminRepository.save(admin);
    }


    @Override
    public List<Admin> FindAll() {
        return adminRepository.findAll();
    }


    @Override
    public Admin FindAdminByUsername(String username) {
        Optional<Admin> admin = adminRepository.findByUsername(username);
        if (admin.isPresent()) {
            return admin.get();
        } else {
            throw new NotFoundException(String.format("No Record with the userName Admin [%s] was found in our database", username));
        }
    }

    @Override
    public Admin FindById(Long id) {
        Optional<Admin> admin = adminRepository.findById(id);
        if (admin.isPresent()) {
            return admin.get();
        } else {
            throw new NotFoundException(String.format("No Record with the id Admin [%s] was found in our database", id));
        }
    }

    @Override
    public Boolean ExistsByUsername(String username) {
        return adminRepository.existsByUsername(username);
    }

    @Override
    public Admin UpdateAdmin(Admin admin, Long id) {
        if (adminRepository.findById(id).isPresent()) {

//            adminUpdate.get().setPassword(new BCryptPasswordEncoder().encode(admin.getPassword()));
            return adminRepository.save(admin);
        } else {
            throw new NotFoundException(String.format("No Record with the id Admin [%s] was found in our database", id));
        }
    }

    @Override
    public void DeleteAdmin(Long id) {
        Optional<Admin> admin = adminRepository.findById(id);
        if (admin.isPresent()) {
            adminRepository.deleteById(id);
        } else {
            throw new NotFoundException(String.format("No Record with the id Message [%s] was found in our database", id));
        }
    }
}

