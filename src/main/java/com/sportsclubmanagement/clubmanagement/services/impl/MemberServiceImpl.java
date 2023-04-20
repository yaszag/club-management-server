package com.sportsclubmanagement.clubmanagement.services.impl;


import com.sportsclubmanagement.clubmanagement.entity.Member;
import com.sportsclubmanagement.clubmanagement.repositories.MemberRepository;
import com.sportsclubmanagement.clubmanagement.services.MemberService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class MemberServiceImpl implements MemberService {
    @Autowired
    private MemberRepository memberRepository;

    @Override
    public Member createMember(Member member) {
        return memberRepository.save(member);
    }

    @Override
    public Member updateMember(Long id, Member member) {
        Member existingMember = getMemberById(id);
        if (existingMember == null) {
            throw new IllegalArgumentException("Member with ID " + id + " not found.");
        }
        return memberRepository.save(member);
    }

    @Override
    public void deleteMember(Long id) {
        Member existingMember = getMemberById(id);
        if (existingMember == null) {
            throw new IllegalArgumentException("Member with ID " + id + " not found.");
        }
        memberRepository.delete(existingMember);
    }

    @Override
    public Member getMemberById(Long id) {
        return memberRepository.findById(id).orElse(null);
    }

    @Override
    public List<Member> getAllMembers() {
        return memberRepository.findAll();
    }


}

