package com.sportsclubmanagement.clubmanagement.Utils;

import com.sportsclubmanagement.clubmanagement.entity.Admin;
import com.sportsclubmanagement.clubmanagement.repositories.AdminRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContext;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Service
public class CurrentUser {

    private final AdminRepository adminRepository;

    @Autowired
    public CurrentUser(AdminRepository adminRepository) {
        this.adminRepository = adminRepository;
    }

    public Admin getCurrentUser() {
        SecurityContext securityContext = SecurityContextHolder.getContext();
        Authentication authentication = securityContext.getAuthentication();
        UserDetails springSecurityUser;
        String userName = null;

        if (authentication != null) {
            if (authentication.getPrincipal() instanceof UserDetails) {
                springSecurityUser = (UserDetails) authentication.getPrincipal();
                userName = springSecurityUser.getUsername();
            } else if (authentication.getPrincipal() instanceof String) {
                userName = (String) authentication.getPrincipal();
            }
        }
        Optional<Admin> user = adminRepository.findByUsername(userName);
        return user.orElse(new Admin());
    }
}
