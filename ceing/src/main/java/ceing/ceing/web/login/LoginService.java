package ceing.ceing.web.login;

import ceing.ceing.domain.Member;
import ceing.ceing.repository.LoginTempRepository;
import ceing.ceing.repository.MemberRepository;
import jakarta.persistence.EntityManager;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@Service
@Transactional
@Slf4j
public class LoginService {

    private final EntityManager em;
    private final MemberRepository memberRepository;

    @Autowired
    public LoginService(EntityManager em , MemberRepository memberRepository){
        this.em=em;
        this.memberRepository = memberRepository;

    }
    public Member login(String loginId , String password){
        return memberRepository.findByLoginId(loginId).filter(member -> member.getPassword().equals(password)).orElse(null);
    }

}
