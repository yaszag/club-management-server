package com.sportsclubmanagement.clubmanagement.repositories;


import com.sportsclubmanagement.clubmanagement.entity.Admin;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.Optional;

@Repository
public interface AdminRepository extends JpaRepository<Admin, Long> {

    boolean existsByUsername(String username);

    Optional<Admin> findByUsername(String username);
}

