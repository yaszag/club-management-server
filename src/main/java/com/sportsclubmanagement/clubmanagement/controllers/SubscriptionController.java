package com.sportsclubmanagement.clubmanagement.controllers;

import com.sportsclubmanagement.clubmanagement.entity.Subscription;
import com.sportsclubmanagement.clubmanagement.services.SubscriptionService;
import org.springframework.format.annotation.DateTimeFormat;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import java.time.LocalDate;
import java.util.List;

@RestController
@RequestMapping("/api/subscriptions")
public class SubscriptionController {

    private final SubscriptionService subscriptionService;

    public SubscriptionController(SubscriptionService subscriptionService) {
        this.subscriptionService = subscriptionService;
    }

    @GetMapping
    public ResponseEntity<List<Subscription>> getAllSubscriptions() {
        List<Subscription> subscriptions = subscriptionService.getAllSubscriptions();
        return ResponseEntity.ok(subscriptions);
    }

    @GetMapping("/priceByDate")
    public ResponseEntity<?> getTotalPriceByDate(@RequestParam(value = "startDate") @DateTimeFormat(pattern = "yyyy-MM-dd") LocalDate startDate,
                                                 @RequestParam(value = "endDate") @DateTimeFormat(pattern = "yyyy-MM-dd") LocalDate endDate) {
        return new ResponseEntity<>(subscriptionService.getTotalPriceByDate(startDate, endDate), HttpStatus.OK);
    }

    @GetMapping("/priceByDesignation")
    public ResponseEntity<?> getTotalPriceByDesignation(@RequestParam(value = "designation") String designation) {
        return new ResponseEntity<>(subscriptionService.getTotalPriceByDesignation(designation), HttpStatus.OK);
    }

    @GetMapping("/dailyPrice")
    public ResponseEntity<?> getTotalDailyPrice() {
        return new ResponseEntity<>(subscriptionService.getTotalDailyPrice(), HttpStatus.OK);
    }
}