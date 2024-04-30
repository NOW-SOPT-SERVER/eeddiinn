package org.sopt.seminar2.dto;

import org.sopt.seminar2.domain.Member;
import org.sopt.seminar2.domain.Part;

public record MemberGetDto(

    long id,

    String name,
    Part part,
    int age
) {
    public static MemberGetDto of(Member member) {
        return new MemberGetDto(member.getId(), member.getName(), member.getPart(), member.getAge());
    }
}
