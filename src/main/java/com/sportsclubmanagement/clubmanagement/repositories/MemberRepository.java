package com.sportsclubmanagement.clubmanagement.repositories;

import com.sportsclubmanagement.clubmanagement.entity.Member;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface MemberRepository extends JpaRepository<Member, Long> {
    // Custom query methods for Member entity
}
