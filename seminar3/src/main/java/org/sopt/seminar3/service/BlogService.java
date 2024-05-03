package org.sopt.seminar3.service;

import jakarta.transaction.Transactional;
import lombok.RequiredArgsConstructor;
import org.sopt.seminar3.common.dto.ErrorMessage;
import org.sopt.seminar3.domain.Blog;
import org.sopt.seminar3.domain.Member;
import org.sopt.seminar3.dto.request.BlogCreateRequest;
import org.sopt.seminar3.dto.request.BlogTitleUpdateRequest;
import org.sopt.seminar3.exception.NotFoundException;
import org.sopt.seminar3.repository.BlogRepository;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class BlogService {
    private final BlogRepository blogRepository;
    private final MemberService memberService;


    public String create(Long memberId, BlogCreateRequest blogCreateRequest) {
        Member member = memberService.findById(memberId);
        Blog blog = blogRepository.save(Blog.create(member, blogCreateRequest));
        return blog.getId().toString();
    }

    public Blog findById(Long blogId) {
        return blogRepository.findById(blogId).orElseThrow(
            () -> new NotFoundException(ErrorMessage.BLOG_NOT_FOUND)
        );
    }

    @Transactional
    public void updateTitle(Long blogId, BlogTitleUpdateRequest blogTitleUpdateRequest) {
        Blog blog = findById(blogId);
        blog.updateTitle(blogTitleUpdateRequest);
    }
}
