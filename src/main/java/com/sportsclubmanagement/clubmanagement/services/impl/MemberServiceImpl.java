package com.sportsclubmanagement.clubmanagement.services.impl;


import com.sportsclubmanagement.clubmanagement.entity.Activity;
import com.sportsclubmanagement.clubmanagement.entity.DTO.AddMemberDTO;
import com.sportsclubmanagement.clubmanagement.entity.Member;
import com.sportsclubmanagement.clubmanagement.entity.Subscription;
import com.sportsclubmanagement.clubmanagement.entity.SubscriptionDetails;
import com.sportsclubmanagement.clubmanagement.exeptions.NotFoundException;
import com.sportsclubmanagement.clubmanagement.repositories.ActivityRepository;
import com.sportsclubmanagement.clubmanagement.repositories.MemberRepository;
import com.sportsclubmanagement.clubmanagement.services.MemberService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.time.LocalDate;
import java.util.List;
import java.util.Optional;

@Service
public class MemberServiceImpl implements MemberService {

    private final MemberRepository memberRepository;
    private final ActivityRepository activityRepository;

    @Autowired
    public MemberServiceImpl(MemberRepository memberRepository, ActivityRepository activityRepository) {
        this.memberRepository = memberRepository;
        this.activityRepository = activityRepository;
    }

    @Override
    public Member createMember(AddMemberDTO addMemberDTO) {
        List<Activity> activities = activityRepository.findAllById(addMemberDTO.getActivityIds());

        Subscription subscription = new Subscription();
        Member member = new Member();
        member.setName(addMemberDTO.getName());
        member.setEmail(addMemberDTO.getEmail());
        member.setPhone(addMemberDTO.getPhone());
        member.setActivities(activities);

        LocalDate startDate = addMemberDTO.getSubscriptionDTO().getStartDate();
        SubscriptionDetails subscriptionDetails = addMemberDTO.getSubscriptionDTO().getSubscriptionDetails();
        subscription.setStartDate(startDate);
        subscription.setEndDate(calculateEndDate(startDate, subscriptionDetails.getDesignation()));
        subscription.setSubscriptionDetails(subscriptionDetails);

        member.setSubscription(subscription);
        return memberRepository.save(member);
    }

    @Override
    public Member updateMember(Long id, AddMemberDTO addMemberDTO) {

        Optional<Member> member = memberRepository.findById(id);
        if (member.isPresent()) {
            List<Activity> activities = activityRepository.findAllById(addMemberDTO.getActivityIds());

            Subscription subscription = new Subscription();
            member.get().setName(addMemberDTO.getName());
            member.get().setEmail(addMemberDTO.getEmail());
            member.get().setPhone(addMemberDTO.getPhone());
            member.get().setActivities(activities);

            LocalDate startDate = addMemberDTO.getSubscriptionDTO().getStartDate();
            SubscriptionDetails subscriptionDetails = addMemberDTO.getSubscriptionDTO().getSubscriptionDetails();
            subscription.setStartDate(startDate);
            subscription.setEndDate(calculateEndDate(startDate, subscriptionDetails.getDesignation()));
            subscription.setSubscriptionDetails(subscriptionDetails);

            member.get().setSubscription(subscription);

            member.get().setId(id);
            return memberRepository.save(member.get());
        } else {
            throw new NotFoundException(String.format("No Record with the id member [%s] was found in our database", id));
        }
    }

    @Override
    public void deleteMember(Long id) {
        Optional<Member> existingMember = memberRepository.findById(id);
        if (existingMember.isPresent()) {

            memberRepository.delete(existingMember.get());
        } else
            throw new NotFoundException("Member with ID " + id + " not found.");
    }

    @Override
    public Member getMemberById(Long id) {
        return memberRepository.findById(id).orElse(null);
    }

    @Override
    public List<Member> getAllMembers() {
        return memberRepository.findAll();
    }

    private LocalDate calculateEndDate(LocalDate startDate, String des) {
        switch (des) {
            case "Quarterly":
                return startDate.plusMonths(3);
            case "Semi-Annual":
                return startDate.plusMonths(6);
            case "Yearly":
                return startDate.plusYears(1);
            default:
                return startDate.plusMonths(1);

        }
    }
}

