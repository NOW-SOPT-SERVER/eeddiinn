package org.sopt.seminar2.dto;

import org.sopt.seminar2.domain.Part;

public record MemberCreateDto(

    String name,
    Part part,
    int age
) {
}
