package org.sopt.seminar3.repository;

import org.sopt.seminar3.common.dto.ErrorMessage;
import org.sopt.seminar3.domain.Blog;
import org.sopt.seminar3.exception.NotFoundException;
import org.springframework.data.jpa.repository.JpaRepository;

import java.awt.print.Book;

public interface BlogRepository extends JpaRepository<Blog, Long> {
}
