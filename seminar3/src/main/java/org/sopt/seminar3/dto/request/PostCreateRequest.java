package org.sopt.seminar3.dto.request;

import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.validation.constraints.Size;

public record PostCreateRequest(
    
   @Size(max = 10, message = "제목이 최대 글자 수(10자)를 초과했습니다.")
   String name,
   @Size(max = 100, message = "내용이 최대 글자 수(100자)를 초과했습니다.")
   String content
) {
}
