package ceing.ceing.repository;

import ceing.ceing.domain.Member;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import java.util.*;

@Repository
@Slf4j
public class LoginTempRepository {

    private static Map<Long , Member> store = new HashMap<>();
    private static Long sequence = 0L;

    public Member save(Member member){
        member.setMemberId(++sequence);
        store.put(member.getMemberId() , member);
        log.info("member = {}" , member);
        return member;
    }

    public Optional<Member> findById(Long memberId){
        return Optional.ofNullable(store.get(memberId));
    }
    public Optional<Member> findByLoginId(String loginId){
        return Optional.ofNullable(findAll().stream().filter(member -> member.getLoginId().equals(loginId)).findFirst().orElse(null));
    }

    public List<Member> findAll(){return new ArrayList<>(store.values());
    }

}
