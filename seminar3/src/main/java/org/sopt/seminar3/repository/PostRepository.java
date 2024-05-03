package org.sopt.seminar3.repository;

import org.sopt.seminar3.domain.Blog;
import org.sopt.seminar3.domain.Post;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface PostRepository extends JpaRepository<Post, Long> {
    List<Post> findByBlogId(Long blogId);
}
