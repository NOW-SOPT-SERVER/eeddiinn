package org.sopt.seminar3.repository;

import org.sopt.seminar3.domain.Blog;
import org.springframework.data.jpa.repository.JpaRepository;


public interface BlogRepository extends JpaRepository<Blog, Long> {
}
