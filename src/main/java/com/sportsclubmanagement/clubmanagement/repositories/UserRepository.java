package com.sportsclubmanagement.clubmanagement.repositories;

import com.sportsclubmanagement.clubmanagement.entity.Admin;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.Optional;

@Repository
public interface UserRepository extends JpaRepository<Admin, Long> {

    Optional<Admin> findByUsername(String userName);

    Boolean existsByUsername(String userName);

}
