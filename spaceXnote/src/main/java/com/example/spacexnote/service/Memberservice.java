//package com.example.spacexnote.service;
//
//import com.example.spacexnote.dto.MemberRequestDto;
//import com.example.spacexnote.repository.MemberRepository;
//import org.springframework.beans.factory.annotation.Autowired;
//import org.springframework.stereotype.Service;
//
//@Service
//public class Memberservice {
//    private final PasswordEncoder passwordEncoder;
//    private final MemberRepository memberRepository;
//
//    @Autowired
//    public MemeberService(PasswordEncoder passwordEncoder, MemberRepository memberRepository) {
//        this.passwordEncoder = passwordEncoder;
//        this.memberRepository = memberRepository;
//    }
//
//    public void registerUser(MemberRequestDto requestDto) {
//        String membername = requestDto.getMembername();
//        String email = requestDto.getEmail();
//
//        //패스워드 암호화
//        String password = passwordEncoder.encode(requestDto.getPassword());
//
//        User user = new User(nickname, password, email);
//        userRepository.save(user);
//    }
//}
