<<<<<<< HEAD
//package com.example.spacexnote.entity;
//
//import lombok.AllArgsConstructor;
//import lombok.Getter;
//import lombok.NoArgsConstructor;
//
//import javax.persistence.*;
//
//@Getter
//@NoArgsConstructor      //기본 생성자를 만들어줍니다.
//@AllArgsConstructor
//@Entity     //DB 테이블 역할을 합니다
//public class Member extends Timestamped {
//
//    @Id
//    @GeneratedValue(strategy = GenerationType.IDENTITY)     //ID가 자동으로 생성 및 증가합니다.
//    private Long id;
//
//    // nullable: null 허용 여부
//    // unique: 중복 허용 여부 (false 일때 중복 허용)
//    @Column(nullable = false)
//    private String membername;
//
//    @Column(nullable = false, unique = true)
//    private String email;
//
//    @Column(nullable = false)
//    private String password;
//
//    public Member(String membername, String email, String password) {
//        this.membername = membername;
//        this.email = email;
//        this.password = password;
//    }
//}
//
=======
package com.example.spacexnote.entity;

import com.example.spacexnote.dto.MemberRequestDto;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;

import javax.persistence.*;

@Getter
@NoArgsConstructor      //기본 생성자를 만들어줍니다.
@AllArgsConstructor
@Builder
@Entity     //DB 테이블 역할을 합니다
public class Member extends Timestamped {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)     //ID가 자동으로 생성 및 증가합니다.
    private Long id;

    // nullable: null 허용 여부
    // unique: 중복 허용 여부 (false 일때 중복 허용)
    @Column(nullable = false)
    private String membername;

    @Column(nullable = false, unique = true)
    private String email;

    @Column(nullable = false)
    private String password;

    public Member(MemberRequestDto memberRequestDto) {
        this.membername = memberRequestDto.getMembername();
        this.email = memberRequestDto.getEmail();
        this.password = memberRequestDto.getPassword();
    }
}

>>>>>>> f8be561e8d3c233d00f68724ca14a5f9da0f3373
