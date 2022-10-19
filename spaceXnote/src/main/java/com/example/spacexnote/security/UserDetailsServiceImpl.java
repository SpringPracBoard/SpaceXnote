package com.example.spacexnote.security;

import com.example.spacexnote.entity.Member;
import com.example.spacexnote.repository.MemberRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class UserDetailsServiceImpl implements UserDetailsService {

    //userdetail 안에 account를 넣어주는 서비스
    private final MemberRepository memberRepository;

    //반환 타입이 UserDetails고 return값이 userDetails
    @Override
    public UserDetails loadUserByUsername(String email) throws UsernameNotFoundException {

        Member member = memberRepository.findByEmail(email).orElseThrow(
                () -> new RuntimeException("Not Found Account")
        );

        UserDetailsImpl userDetails = new UserDetailsImpl(member);
        userDetails.setMember(member);

        return userDetails;
    }
}
