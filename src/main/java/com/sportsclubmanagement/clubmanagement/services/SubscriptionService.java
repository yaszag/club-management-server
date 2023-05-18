package com.sportsclubmanagement.clubmanagement.services;

import com.sportsclubmanagement.clubmanagement.entity.Subscription;

import java.math.BigDecimal;
import java.time.LocalDate;
import java.util.List;

public interface SubscriptionService {

    List<Subscription> getAllSubscriptions();

    Subscription getSubscriptionById(Long id);

    BigDecimal getTotalPriceByDate(LocalDate startDate, LocalDate EndDate);

    BigDecimal getTotalPriceByDesignation(String designation);

    BigDecimal getTotalDailyPrice();

}
