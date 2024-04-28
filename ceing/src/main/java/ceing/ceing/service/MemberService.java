package ceing.ceing.service;

import ceing.ceing.domain.Member;
import ceing.ceing.repository.MemberRepository;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@Service
@Transactional
@Slf4j
@RequiredArgsConstructor
public class MemberService {


    private final MemberRepository memberRepository;

    public Member login(String loginId , String password){
        return memberRepository.findByLoginId(loginId).filter(member -> member.getPassword().equals(password)).orElse(null);
    }
    public Member findByLoginId(String loginId){
        return memberRepository.findByLoginId(loginId).orElse(null);
    }

    public Member save(Member member){
        memberRepository.save(member);
        return member;
    }

}
