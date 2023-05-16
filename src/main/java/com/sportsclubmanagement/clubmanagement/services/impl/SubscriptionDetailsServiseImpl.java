package com.sportsclubmanagement.clubmanagement.services.impl;

import com.sportsclubmanagement.clubmanagement.entity.SubscriptionDetails;
import com.sportsclubmanagement.clubmanagement.repositories.SubscriptionDetailsRepository;
import com.sportsclubmanagement.clubmanagement.services.SubscriptionDetailsServise;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class SubscriptionDetailsServiseImpl implements SubscriptionDetailsServise {


    private final SubscriptionDetailsRepository subscriptionDetailsRepository;

    @Autowired
    public SubscriptionDetailsServiseImpl(SubscriptionDetailsRepository subscriptionDetailsRepository) {
        this.subscriptionDetailsRepository = subscriptionDetailsRepository;
    }

    @Override
    public List<SubscriptionDetails> getAllSubscriptionsDetails() {
        return subscriptionDetailsRepository.findAll();
    }
}
