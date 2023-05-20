package com.sportsclubmanagement.clubmanagement.repositories;


import com.sportsclubmanagement.clubmanagement.entity.Subscription;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.time.LocalDate;
import java.util.List;

@Repository
public interface SubscriptionRepository extends JpaRepository<Subscription, Long> {

    List<Subscription> findByStartDateGreaterThanEqualAndEndDateLessThanEqual(LocalDate startDate, LocalDate endDate);

    List<Subscription> findByStartDateEquals(LocalDate startDate);

    List<Subscription> findBySubscriptionDetails_Designation(String designation);

}