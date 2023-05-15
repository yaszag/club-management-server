package com.sportsclubmanagement.clubmanagement.services.impl;

import com.sportsclubmanagement.clubmanagement.entity.Subscription;
import com.sportsclubmanagement.clubmanagement.repositories.SubscriptionRepository;
import com.sportsclubmanagement.clubmanagement.services.SubscriptionService;
import org.springframework.stereotype.Service;

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
}