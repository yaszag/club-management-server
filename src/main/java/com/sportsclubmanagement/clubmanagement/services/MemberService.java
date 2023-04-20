package com.sportsclubmanagement.clubmanagement.services;

import com.sportsclubmanagement.clubmanagement.entity.Activity;
import com.sportsclubmanagement.clubmanagement.entity.Member;

import java.util.List;

public interface MemberService {
    Member createMember(Member member);
    Member updateMember(Long id, Member member);
    void deleteMember(Long id);
    Member getMemberById(Long id);
    List<Member> getAllMembers();
}

