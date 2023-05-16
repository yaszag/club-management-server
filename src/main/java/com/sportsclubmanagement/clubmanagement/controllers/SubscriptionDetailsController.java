package com.sportsclubmanagement.clubmanagement.controllers;

import com.sportsclubmanagement.clubmanagement.entity.Subscription;
import com.sportsclubmanagement.clubmanagement.entity.SubscriptionDetails;
import com.sportsclubmanagement.clubmanagement.services.SubscriptionDetailsServise;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping("/api/subscriptions_details")
public class SubscriptionDetailsController {

    private final SubscriptionDetailsServise subscriptionDetailsServise;

    @Autowired
    public SubscriptionDetailsController(SubscriptionDetailsServise subscriptionDetailsServise) {
        this.subscriptionDetailsServise = subscriptionDetailsServise;
    }

    @GetMapping
    public ResponseEntity<List<SubscriptionDetails>> getAllSubscriptionsDetails() {
        List<SubscriptionDetails> subscriptions = subscriptionDetailsServise.getAllSubscriptionsDetails();
        return ResponseEntity.ok(subscriptions);
    }
}
