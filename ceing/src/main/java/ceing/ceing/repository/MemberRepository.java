package ceing.ceing.repository;

import ceing.ceing.domain.Item;
import ceing.ceing.domain.Member;
import jakarta.persistence.EntityManager;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Optional;

/**
 * 데이터 접근 계층은 그저 DB와의 소통을 위해 분리된 계층임 , 비즈니스적인 로직은 전부 서비스에서 해결하자 ! 그저
 * 즉 Repository : DB에서 CRUD만
 */
@Repository
@RequiredArgsConstructor
@Slf4j
public class MemberRepository {

    /**
     *   findById의 경우 회원 없을 경우 NoSuchElementException 처리 필요
     *
     */
    private final EntityManager em;

    //CQS 패턴 못지킴
    public Long save(Member member){
        em.persist(member);
        return member.getId();
    }

    //Query
    public Optional<Member> findById(Long memberId){
        return Optional.ofNullable(em.find(Member.class , memberId));
    }

    public Optional<Member> findByLoginId(String loginId){
        return em.createQuery("select m from Member m where m.loginId = :loginId", Member.class)
            .setParameter("loginId", loginId)
            .getResultList().stream().findAny();
    }


//영속성 컨텍스트를 쓰면?

    public List<Member> findAll(){
        return em.createQuery("select m from Member m" , Member.class).getResultList();
    }



}
