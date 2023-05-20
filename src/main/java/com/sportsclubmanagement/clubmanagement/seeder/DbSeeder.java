package com.sportsclubmanagement.clubmanagement.seeder;


import com.sportsclubmanagement.clubmanagement.entity.SubscriptionDetails;
import com.sportsclubmanagement.clubmanagement.repositories.SubscriptionDetailsRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.stereotype.Component;

import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.List;

@Component
public class DbSeeder implements CommandLineRunner {

    private final SubscriptionDetailsRepository subscriptionDetailsRepository;

    @Autowired
    public DbSeeder(SubscriptionDetailsRepository subscriptionDetailsRepository) {
        this.subscriptionDetailsRepository = subscriptionDetailsRepository;
    }

    @Override
    public void run(String... args) throws Exception {
        subscriptionDetailsRepository.saveAll(createSubscriptionsDetails());
    }

    private List<SubscriptionDetails> createSubscriptionsDetails() {

        List<SubscriptionDetails> subscriptionDetails = new ArrayList<>();
        subscriptionDetails.add(new SubscriptionDetails(1L, BigDecimal.valueOf(100), "Monthly", "Access to club facilities for 1 month"));
        subscriptionDetails.add(new SubscriptionDetails(2L, BigDecimal.valueOf(250), "Quarterly", "Access to club facilities for 3 months"));
        subscriptionDetails.add(new SubscriptionDetails(3L, BigDecimal.valueOf(500), "Semi-Annual", "Access to club facilities for 6 months"));
        subscriptionDetails.add(new SubscriptionDetails(4L, BigDecimal.valueOf(900), "Yearly", "Access to club facilities for 1 year"));

        return subscriptionDetails;
    }
}

