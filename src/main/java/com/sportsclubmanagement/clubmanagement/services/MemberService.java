package com.sportsclubmanagement.clubmanagement.services;

import com.sportsclubmanagement.clubmanagement.entity.DTO.AddMemberDTO;
import com.sportsclubmanagement.clubmanagement.entity.Member;

import javax.transaction.Transactional;
import java.util.List;

public interface MemberService {

    @Transactional
    Member createMember(AddMemberDTO member);

    Member updateMember(Long id, AddMemberDTO member);

    void deleteMember(Long id);

    Member getMemberById(Long id);

    List<Member> getAllMembers();
}

