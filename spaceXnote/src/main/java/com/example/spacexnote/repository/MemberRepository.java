package com.example.spacexnote.repository;

import com.example.spacexnote.entity.Member;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.Optional;

@Repository
public interface MemberRepository extends JpaRepository<Member, Long> {
    Optional<Member> findByMembername(String membername);
    boolean existsByEmail(String email);
    boolean existsMemberBy(String nickname);
}
