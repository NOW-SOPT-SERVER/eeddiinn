package org.sopt.seminar3.controller;

import jakarta.validation.Valid;
import lombok.RequiredArgsConstructor;
import org.sopt.seminar3.common.dto.SuccessMessage;
import org.sopt.seminar3.common.dto.SuccessStatusResponse;
import org.sopt.seminar3.dto.request.BlogCreateRequest;
import org.sopt.seminar3.dto.request.PostCreateRequest;
import org.sopt.seminar3.dto.response.PostFindDto;
import org.sopt.seminar3.service.BlogService;
import org.sopt.seminar3.service.PostService;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/v1")
@RequiredArgsConstructor
public class PostController {

    private final PostService postService;

    @PostMapping("/post")
    public ResponseEntity<SuccessStatusResponse> createPost(
        @RequestHeader(name = "blogId") Long blogId,
        @RequestHeader(name = "memberId") Long memberId,
        @Valid @RequestBody PostCreateRequest postCreateRequest
        ) {
        return ResponseEntity.status(HttpStatus.CREATED).header(
                "Location",
                postService.create(blogId, memberId, postCreateRequest))
                   .body(SuccessStatusResponse.of(SuccessMessage.POST_CREATE_SUCCESS));
    }

    @GetMapping("/post")
    public ResponseEntity<List<PostFindDto>> getPost(
        @RequestHeader(name = "blogId") Long blogId ) {
        return ResponseEntity.ok(postService.getPosts(blogId));
    }
}
