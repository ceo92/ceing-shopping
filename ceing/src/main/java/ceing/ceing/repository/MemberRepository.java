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

@Repository
@Slf4j
public class MemberRepository {

    /**
     *   findById의 경우 회원 없을 경우 NoSuchElementException 처리 필요
     *
     */
    private EntityManager em;

    @Autowired
    public MemberRepository(EntityManager em){
        this.em=em;
    }

    public Member save(Member member){
        em.persist(member);
        log.info("member = {}" , member);
        return member;
    }

    public Optional<Member> findById(Long memberId){
        return Optional.ofNullable(em.find(Member.class , memberId));
    }

    public Optional<Member> findByLoginId(String loginId){
        List<Member> findMembers = findAll();
        return findMembers.stream().filter(member -> member.getLoginId().equals(loginId)).findFirst();
    }


    public void update(Long memberId , Member member){
        Member findMember = findById(memberId).orElseThrow();
        findMember.setAddress(member.getAddress());
        findMember.setUsername(member.getUsername());
        findMember.setPhoneNumber(member.getPhoneNumber());
    }

    public List<Member> findAll(){
        String jpql = "select m from Member m";
        return em.createQuery(jpql).getResultList();
    }



}
