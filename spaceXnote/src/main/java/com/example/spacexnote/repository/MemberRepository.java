<<<<<<< HEAD
//package com.example.spacexnote.repository;
//
//import com.example.spacexnote.entity.Member;
//import org.springframework.data.jpa.repository.JpaRepository;
//import org.springframework.stereotype.Repository;
//import java.util.Optional;
//
//@Repository
//public interface MemberRepository extends JpaRepository<Member, Long> {
//    Optional<Member> findByMembername(String membername);
//    boolean existsByEmail(String email);
//    boolean existsMemberBy(String nickname);
//
//}
=======
package com.example.spacexnote.repository;

import com.example.spacexnote.entity.Member;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import java.util.Optional;

@Repository
public interface MemberRepository extends JpaRepository<Member, Long> {
    Optional<Member> findByEmail(String email);

}
>>>>>>> f8be561e8d3c233d00f68724ca14a5f9da0f3373
