package com.sportsclubmanagement.clubmanagement.services;

import com.sportsclubmanagement.clubmanagement.entity.Admin;
import com.sportsclubmanagement.clubmanagement.entity.DTO.JwtResponse;
import com.sportsclubmanagement.clubmanagement.entity.DTO.LoginRequest;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public interface AdminService {

    JwtResponse Authenticate(LoginRequest loginRequest);

    Admin AddAdmin(Admin admin);

    List<Admin> FindAll();

    Admin FindById(Long id);

    Boolean ExistsByUsername(String username);

    Admin FindAdminByUsername(String username);

    Admin UpdateAdmin(Admin admin, Long id);

    void DeleteAdmin(Long id);
}
