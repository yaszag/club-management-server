package com.sportsclubmanagement.clubmanagement.services;

import com.sportsclubmanagement.clubmanagement.entity.Subscription;

import java.util.List;

public interface SubscriptionService {
    List<Subscription> getAllSubscriptions();
    Subscription getSubscriptionById(Long id);

}
