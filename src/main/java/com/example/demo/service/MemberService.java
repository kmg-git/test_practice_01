package com.example.demo.service;

import com.example.demo.domain.Member;
import com.example.demo.exception.DuplicateEmailException;
import com.example.demo.exception.ErrorCode;
import com.example.demo.exception.MemberNotFoundException;
import com.example.demo.repository.MemberRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

// service/MemberService.java
@Service
@RequiredArgsConstructor
public class MemberService {

    private final MemberRepository memberRepository;

    public Member join(String name, String email, int age) {

        // 검증로직을 한번 더 넣어줄것인데
        // 이미 가입된 이메일이 있는지
        if (memberRepository.existsByEmail(email)) {
            throw new DuplicateEmailException(ErrorCode.DUPLICATE_EMAIL);
        }

        return memberRepository.save(name, email, age);
    }

    public Member getMember(Long id) {
        return memberRepository.findById(id)
                .orElseThrow(() -> new MemberNotFoundException(ErrorCode.MEMBER_NOT_FOUND));
    }

}