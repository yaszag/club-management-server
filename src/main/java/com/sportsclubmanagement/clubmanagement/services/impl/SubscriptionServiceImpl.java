package com.sportsclubmanagement.clubmanagement.services.impl;

import com.sportsclubmanagement.clubmanagement.entity.Subscription;
import com.sportsclubmanagement.clubmanagement.repositories.SubscriptionRepository;
import com.sportsclubmanagement.clubmanagement.services.SubscriptionService;
import org.springframework.stereotype.Service;

import java.math.BigDecimal;
import java.time.LocalDate;
import java.util.List;

@Service
public class SubscriptionServiceImpl implements SubscriptionService {

    private final SubscriptionRepository subscriptionRepository;

    public SubscriptionServiceImpl(SubscriptionRepository subscriptionRepository) {
        this.subscriptionRepository = subscriptionRepository;
    }

    @Override
    public List<Subscription> getAllSubscriptions() {
        return subscriptionRepository.findAll();
    }

    @Override
    public Subscription getSubscriptionById(Long id) {
        return subscriptionRepository.findById(id).orElse(null);
    }

    @Override
    public BigDecimal getTotalPriceByDate(LocalDate startDate, LocalDate EndDate) {
        List<Subscription> subscriptions = subscriptionRepository.findByStartDateGreaterThanEqualAndEndDateLessThanEqual(startDate, EndDate);
        if (subscriptions.size() > 0) {
            return subscriptions.stream()
                    .map(subscription -> subscription.getSubscriptionDetails().getPrice())
                    .reduce(BigDecimal.ZERO, BigDecimal::add);
        }
        return BigDecimal.ZERO;
    }

    @Override
    public BigDecimal getTotalPriceByDesignation(String designation) {
        List<Subscription> subscriptions = subscriptionRepository.findBySubscriptionDetails_Designation(designation);
        if (subscriptions.size() > 0) {
            return subscriptions.stream()
                    .map(subscription -> subscription.getSubscriptionDetails().getPrice())
                    .reduce(BigDecimal.ZERO, BigDecimal::add);
        }
        return BigDecimal.ZERO;
    }

    @Override
    public BigDecimal getTotalDailyPrice() {
        List<Subscription> subscriptions = subscriptionRepository.findByStartDateEquals(LocalDate.now());
        if (subscriptions.size() > 0) {
            return subscriptions.stream()
                    .map(subscription -> subscription.getSubscriptionDetails().getPrice())
                    .reduce(BigDecimal.ZERO, BigDecimal::add);
        }
        return BigDecimal.ZERO;
    }
}