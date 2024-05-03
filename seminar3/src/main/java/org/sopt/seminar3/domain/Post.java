package org.sopt.seminar3.domain;

import jakarta.persistence.*;
import lombok.Getter;
import lombok.NoArgsConstructor;
import org.sopt.seminar3.dto.request.BlogCreateRequest;
import org.sopt.seminar3.dto.request.PostCreateRequest;

@Entity
@Getter
@NoArgsConstructor
public class Post extends BaseTimeEntity {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private String name;

    private String content;

    @ManyToOne(fetch = FetchType.LAZY)
    private Blog blog;

    private Post(Blog blog, String name, String content) {
        this.blog = blog;
        this.name = name;
        this.content = content;
    }

    public static Post create(Blog blog, PostCreateRequest postCreateRequest) {
        return new Post(blog, postCreateRequest.content(), postCreateRequest.name());
    }
}