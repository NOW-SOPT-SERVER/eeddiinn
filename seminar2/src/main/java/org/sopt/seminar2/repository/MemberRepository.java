package org.sopt.seminar2.repository;

import org.sopt.seminar2.domain.Member;
import org.springframework.data.jpa.repository.JpaRepository;

public interface MemberRepository extends JpaRepository<Member, Long> {
}
