package com.sportsclubmanagement.clubmanagement.seeder;


import com.sportsclubmanagement.clubmanagement.entity.Subscription;
import com.sportsclubmanagement.clubmanagement.repositories.SubscriptionRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.stereotype.Component;

import java.math.BigDecimal;
import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;

@Component
public class DbSeeder implements CommandLineRunner {

    private final SubscriptionRepository subscriptionRepository;

    @Autowired
    public DbSeeder(SubscriptionRepository subscriptionRepository) {
        this.subscriptionRepository = subscriptionRepository;
    }

    @Override
    public void run(String... args) throws Exception {
        List<Subscription> subscriptions = createSubscriptions();

        subscriptionRepository.saveAll(subscriptions);
    }

    private List<Subscription> createSubscriptions() {
        List<Subscription> subscriptions = new ArrayList<>();

        subscriptions.add(new Subscription((long) 1,BigDecimal.valueOf(100), LocalDate.now(), LocalDate.now().plusMonths(1), "Monthly", "Access to club facilities for 1 month",null));
        subscriptions.add(new Subscription((long) 2,BigDecimal.valueOf(250), LocalDate.now(), LocalDate.now().plusMonths(3), "Quarterly", "Access to club facilities for 3 months",null));
        subscriptions.add(new Subscription((long) 3,BigDecimal.valueOf(500), LocalDate.now(), LocalDate.now().plusMonths(6), "Semi-Annual", "Access to club facilities for 6 months",null));
        subscriptions.add(new Subscription((long) 4,BigDecimal.valueOf(900), LocalDate.now(), LocalDate.now().plusYears(1), "Yearly", "Access to club facilities for 1 year",null));

        return subscriptions;
    }
}

