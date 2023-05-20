package com.sportsclubmanagement.clubmanagement.entity.DTO;

import com.sportsclubmanagement.clubmanagement.entity.SubscriptionDetails;
import lombok.Data;

import java.time.LocalDate;

@Data
public class SubscriptionDTO {

    private LocalDate startDate;
    private SubscriptionDetails subscriptionDetails;
}
