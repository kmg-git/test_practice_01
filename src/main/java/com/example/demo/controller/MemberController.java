package com.example.demo.controller;

import com.example.demo.domain.Member;
import com.example.demo.dto.MemberRequest;
import com.example.demo.service.MemberService;
import jakarta.validation.Valid;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;

// controller/MemberController.java
@RestController
@RequestMapping("/api/members")
@RequiredArgsConstructor
public class MemberController {

    private final MemberService memberService;

    // 프론트가 작업하는데

    @PostMapping
    @ResponseStatus(value = HttpStatus.CREATED)
    public Member join(@Valid @RequestBody MemberRequest request) {
        return memberService.join(request.getName(), request.getEmail(), request.getAge());
    }

    @GetMapping("/{id}")
    public Member get(@PathVariable Long id) {
        return memberService.getMember(id);
    }
}