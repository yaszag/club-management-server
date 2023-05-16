package com.sportsclubmanagement.clubmanagement.entity.DTO;

import com.sportsclubmanagement.clubmanagement.entity.Subscription;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.List;


@Data
@NoArgsConstructor
@AllArgsConstructor
public class AddMemberDTO {


    private String name;
    private String email;
    private String phone;
    private SubscriptionDTO subscriptionDTO;
    private List<Long> activityIds;

}
