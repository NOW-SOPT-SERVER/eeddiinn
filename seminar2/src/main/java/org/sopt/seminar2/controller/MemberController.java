package org.sopt.seminar2.controller;

import lombok.RequiredArgsConstructor;
import org.sopt.seminar2.dto.MemberCreateDto;
import org.sopt.seminar2.dto.MemberGetDto;
import org.sopt.seminar2.service.MemberService;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.net.URI;
import java.util.List;

@RestController
@RequiredArgsConstructor
@RequestMapping("/api/v1/member")
public class MemberController {

    private final MemberService memberService;

    @PostMapping
    public ResponseEntity createMember(@RequestBody MemberCreateDto memberCreateDto) {
        return ResponseEntity.created(URI.create(memberService.createMember(memberCreateDto)))
                   .build();
    }

    @GetMapping("/{memberId}")
    public ResponseEntity<MemberGetDto> getMember(@PathVariable Long memberId) {
        return ResponseEntity.ok(memberService.getMember(memberId));
    }

    @DeleteMapping("/{memberId}")
    public void deleteMember(@PathVariable Long memberId) {
        memberService.deleteMember(memberId);
    }

    @GetMapping
    public ResponseEntity<List<MemberGetDto>> getMemberList() {
        return ResponseEntity.ok(memberService.getMemberList());
    }
}
