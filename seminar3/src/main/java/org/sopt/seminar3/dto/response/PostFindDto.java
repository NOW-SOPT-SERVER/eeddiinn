package org.sopt.seminar3.dto.response;

import org.sopt.seminar3.domain.Post;

public record PostFindDto(
    Long id,

    String name,

    String content
) {
    public static PostFindDto of(Post post) {
        return new PostFindDto(post.getId(), post.getName(), post.getContent());
    }
}
