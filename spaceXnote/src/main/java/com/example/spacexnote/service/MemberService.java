package com.example.spacexnote.service;

import com.example.spacexnote.dto.GlobalResDto;
import com.example.spacexnote.dto.LoginReqDto;
import com.example.spacexnote.dto.MemberRequestDto;
import com.example.spacexnote.dto.MemberResponseDto;
import com.example.spacexnote.entity.Member;
import com.example.spacexnote.entity.RefreshToken;
import com.example.spacexnote.jwt.dto.TokenDto;
import com.example.spacexnote.jwt.util.JwtUtil;
import com.example.spacexnote.repository.MemberRepository;
import com.example.spacexnote.repository.RefreshTokenRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import javax.servlet.http.HttpServletResponse;
import java.util.Optional;

@Service
@RequiredArgsConstructor
public class MemberService {

    private final JwtUtil jwtUtil;
    private final PasswordEncoder passwordEncoder;
    private final MemberRepository memberRepository;
    private final RefreshTokenRepository refreshTokenRepository;

    @Transactional
    public GlobalResDto signup(MemberRequestDto memberRequestDto) {
        // email 중복 검사
        if (memberRepository.findByEmail(memberRequestDto.getEmail()).isPresent()) {
            throw new RuntimeException("중복된 이메일입니다.");
        }
        //패스워드 암호화는 법으로 정해져있다. 패스워드 인코딩
//        memberRequestDto.setEncodePwd(passwordEncoder.encode(memberRequestDto.getPassword()));
        //저장
        Member member1 = Member.builder()
                .membername(memberRequestDto.getMembername())
                .password(passwordEncoder.encode(memberRequestDto.getPassword()))
                .email(memberRequestDto.getEmail())
                .build();

        memberRepository.save(member1);
        return new GlobalResDto("Success signUp", HttpStatus.OK.value());
    }

        @Transactional
        public GlobalResDto login(LoginReqDto loginReqDto, HttpServletResponse response) {
        //account가 있는지 확인
        Member member = memberRepository.findByEmail(loginReqDto.getEmail()).orElseThrow(
                () -> new RuntimeException("Not found Account")
        );
        //account의 패스워드와 받아온 패스워드가 같은지 비교
        if(!passwordEncoder.matches(loginReqDto.getPassword(), member.getPassword())) {
            throw new RuntimeException("Not matches Password");
        }
        //로그인을 제대로 한 사람이기 때문에 토큰 발급
        TokenDto tokenDto = jwtUtil.createAllToken(loginReqDto.getEmail());
        //발급과 동시에 db에 저장해야하는데, 한개 이메일에 한개 토큰값이 맞는지 확인해야함
        Optional<RefreshToken> refreshToken = refreshTokenRepository.findByAccountEmail(loginReqDto.getEmail());

        if(refreshToken.isPresent()) {
            refreshTokenRepository.save(refreshToken.get().updateToken(tokenDto.getRefreshToken()));
        }else {
            RefreshToken newToken = new RefreshToken(tokenDto.getRefreshToken(), loginReqDto.getEmail());
            refreshTokenRepository.save(newToken);
        }

        setHeader(response, tokenDto);

        return new GlobalResDto("Success Login", HttpStatus.OK.value());

    }
    //헤더로 빼는건 많이 쓰기때문에 메소드로 빼서 씀
    private void setHeader(HttpServletResponse response, TokenDto tokenDto) {
        response.addHeader(JwtUtil.ACCESS_TOKEN, tokenDto.getAccessToken());
        response.addHeader(JwtUtil.REFRESH_TOKEN, tokenDto.getRefreshToken());
    }
}
