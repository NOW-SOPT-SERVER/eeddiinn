package org.sopt.seminar2.service;

import jakarta.persistence.EntityNotFoundException;
import lombok.RequiredArgsConstructor;
import org.sopt.seminar2.domain.Member;
import org.sopt.seminar2.dto.MemberCreateDto;
import org.sopt.seminar2.dto.MemberGetDto;
import org.sopt.seminar2.repository.MemberRepository;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;
import java.util.stream.Collectors;

@Service
@RequiredArgsConstructor
public class MemberService {

    private final MemberRepository memberRepository;

    @Transactional
    public String createMember(final MemberCreateDto memberCreateDto) {
        Member member = memberRepository.save(Member.create(memberCreateDto.name(), memberCreateDto.part(), memberCreateDto.age()));
        return member.getId().toString();
    }

    public MemberGetDto getMember(Long memberId) {
        return MemberGetDto.of(memberRepository.findById(memberId).orElseThrow(
            () -> new EntityNotFoundException("ID에 해당하는 사용자가 존재하지 않습니다.")
        ));
    }

    @Transactional
    public void deleteMember(Long memberId) {
        Member member = memberRepository.findById(memberId)
                            .orElseThrow(() -> new EntityNotFoundException("ID에 해당하는 사용자가 존재하지 않습니다."));
        memberRepository.delete(member);
    }

    public List<MemberGetDto> getMemberList() {
        return memberRepository.findAll().stream()
                   .map(MemberGetDto::of)
                   .collect(Collectors.toList());
    }
}
