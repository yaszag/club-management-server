package com.sportsclubmanagement.clubmanagement.controllers;

import com.sportsclubmanagement.clubmanagement.entity.Activity;
import com.sportsclubmanagement.clubmanagement.entity.DTO.AddMemberDTO;
import com.sportsclubmanagement.clubmanagement.entity.Member;
import com.sportsclubmanagement.clubmanagement.entity.Subscription;
import com.sportsclubmanagement.clubmanagement.services.ActivityService;
import com.sportsclubmanagement.clubmanagement.services.MemberService;
import com.sportsclubmanagement.clubmanagement.services.SubscriptionService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/members")
public class MemberController {

    @Autowired
    private MemberService memberService;

    @Autowired
    private ActivityService activityService;

    @Autowired
    private SubscriptionService subscriptionService;



    // Endpoint for retrieving all members
    @GetMapping
    public List<Member> getAllMembers() {
        return memberService.getAllMembers();
    }

    // Endpoint for retrieving a member by ID
    @GetMapping("/{id}")
    public ResponseEntity<Member> getMemberById(@PathVariable Long id) {
        Member member = memberService.getMemberById(id);
        if (member == null) {
            return ResponseEntity.notFound().build();
        } else {
            return ResponseEntity.ok(member);
        }
    }

    // Endpoint for creating a new member
    @PostMapping
    public ResponseEntity<Member> createMember(@RequestBody AddMemberDTO addMemberDTO) {
        List<Activity> activities = activityService.getActivitiesByIds(addMemberDTO.getActivityIds());
        Subscription subscription = subscriptionService.getSubscriptionById(addMemberDTO.getSubscriptionId());
        Member member = new Member();
        member.setName(addMemberDTO.getName());
        member.setEmail(addMemberDTO.getEmail());
        member.setPhone(addMemberDTO.getPhone());
        member.setActivities(activities);
        member.setSubscription(subscription);

        Member createdMember = memberService.createMember(member);
        return ResponseEntity.status(HttpStatus.CREATED).body(createdMember);
    }

    // Endpoint for updating a member by ID
    @PutMapping("/{id}")
    public ResponseEntity<Member> updateMember(@PathVariable Long id, @RequestBody Member member) {
        Member updatedMember = memberService.updateMember(id, member);
        if (updatedMember == null) {
            return ResponseEntity.notFound().build();
        } else {
            return ResponseEntity.ok(updatedMember);
        }
    }

    // Endpoint for deleting a member by ID
    @DeleteMapping("/{id}")
    public ResponseEntity<?> delete(@PathVariable Long id) {
        memberService.deleteMember(id);
        return new ResponseEntity<>("Delete Success", HttpStatus.OK);
    }

}

