package com.example.spacexnote.controller;

import com.example.spacexnote.dto.GlobalResDto;
import com.example.spacexnote.dto.LoginReqDto;
import com.example.spacexnote.dto.MemberRequestDto;
import com.example.spacexnote.dto.MemberResponseDto;
import com.example.spacexnote.jwt.util.JwtUtil;
import com.example.spacexnote.security.UserDetailsImpl;
import com.example.spacexnote.service.MemberService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.security.core.annotation.AuthenticationPrincipal;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;

import javax.servlet.http.HttpServletResponse;
import javax.validation.Valid;

@Controller
@RequiredArgsConstructor
@RequestMapping("/api")
public class MemberController {
    private final JwtUtil jwtUtil;
    private final MemberService memberService;


    @PostMapping("/account/signup")
    public ResponseEntity<MemberResponseDto> signup(@RequestBody @Valid MemberRequestDto dto){
        return memberService.signup(dto);
    }

    @PostMapping("/account/login")
    public GlobalResDto login(@RequestBody @Valid LoginReqDto loginReqDto, HttpServletResponse response) {
        return memberService.login(loginReqDto, response);
    }

    @GetMapping("/issue/token")
    public GlobalResDto issuedToken(@AuthenticationPrincipal UserDetailsImpl userDetails, HttpServletResponse response){
        //토큰이 위변조가 없다는 것을 이미 확인해서 넘어옴
        response.addHeader(JwtUtil.ACCESS_TOKEN, jwtUtil.createToken(userDetails.getMember().getEmail(), "Access"));
        return new GlobalResDto("Success IssuedToken", HttpStatus.OK.value());
    }
}
