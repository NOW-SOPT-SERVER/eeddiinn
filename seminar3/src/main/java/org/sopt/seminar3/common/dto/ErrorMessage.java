package org.sopt.seminar3.common.dto;

import lombok.AllArgsConstructor;
import lombok.Getter;
import org.springframework.http.HttpStatus;

@Getter
@AllArgsConstructor
public enum ErrorMessage {
    MEMBER_NOT_FOUND(HttpStatus.NOT_FOUND.value(), "ID에 해당하는 사용자가 존재하지 않습니다."),
    BLOG_NOT_FOUND(HttpStatus.NOT_FOUND.value(), "ID에 해당하는 블로그가 없습니다."),
    POST_NOT_FOUND(HttpStatus.NOT_FOUND.value(), "ID에 해당하는 포스트가 없습니다."),
    POST_NOT_CREATE(HttpStatus.FORBIDDEN.value(), "블로그를 소유하지 않는 사용자여서 글을 작성할 수 없습니다."),
    ;
    private final int status;
    private final String message;
}