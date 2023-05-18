package com.sportsclubmanagement.clubmanagement.controllers;

import com.sportsclubmanagement.clubmanagement.entity.DTO.AddMemberDTO;
import com.sportsclubmanagement.clubmanagement.entity.Member;
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

    private final MemberService memberService;

    private final ActivityService activityService;

    private final SubscriptionService subscriptionService;

    @Autowired
    public MemberController(MemberService memberService, ActivityService activityService, SubscriptionService subscriptionService) {
        this.memberService = memberService;
        this.activityService = activityService;
        this.subscriptionService = subscriptionService;
    }

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
        return new ResponseEntity<>(memberService.createMember(addMemberDTO), HttpStatus.OK);
    }

    // Endpoint for updating a member by ID
    @PutMapping("/{id}")
    public ResponseEntity<?> updateMember(@PathVariable Long id, @RequestBody AddMemberDTO updateMemberDTO) {
        return new ResponseEntity<>(memberService.updateMember(id, updateMemberDTO), HttpStatus.OK);
    }

    // Endpoint for deleting a member by ID
    @DeleteMapping("/{id}")
    public ResponseEntity<?> delete(@PathVariable Long id) {
        memberService.deleteMember(id);
        return new ResponseEntity<>("Delete Success", HttpStatus.OK);
    }
}
