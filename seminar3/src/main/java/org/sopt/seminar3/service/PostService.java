package org.sopt.seminar3.service;


import lombok.AllArgsConstructor;
import lombok.RequiredArgsConstructor;
import org.sopt.seminar3.common.dto.ErrorMessage;
import org.sopt.seminar3.domain.Blog;
import org.sopt.seminar3.domain.Member;
import org.sopt.seminar3.domain.Post;
import org.sopt.seminar3.dto.request.BlogCreateRequest;
import org.sopt.seminar3.dto.request.PostCreateRequest;
import org.sopt.seminar3.dto.response.PostFindDto;
import org.sopt.seminar3.exception.NotFoundException;
import org.sopt.seminar3.repository.BlogRepository;
import org.sopt.seminar3.repository.PostRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;

import static org.springframework.data.jpa.domain.AbstractPersistable_.id;

@Service
@RequiredArgsConstructor
public class PostService {

    @Autowired
    private PostRepository postRepository;

    private final BlogService blogService;

    public String create(Long blogId, Long memberId, PostCreateRequest postCreateRequest) {

        // 블로그를 소유하지 않은 사용자인 경우 예외 처리
        if (!blogService.findById(blogId).getMember().getId().equals(memberId)) {
            throw new NotFoundException(ErrorMessage.BLOG_NOT_CREATE);
        }

        return postRepository.save(Post.create(blogService.findById(blogId), postCreateRequest)).getId().toString();
    }


    public List<PostFindDto> getPosts(Long blogId) {

        if (postRepository.findByBlogId(blogId).isEmpty()) {  // 만약 post가 없으면 에러메시지 출력
            throw new NotFoundException(ErrorMessage.POST_NOT_FOUND);
        }

        return postRepository.findByBlogId(blogId).stream()
                   .map(post -> new PostFindDto(post.getId(), post.getName(), post.getContent()))
                   .collect(Collectors.toList());
    }
}
