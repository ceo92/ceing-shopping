package ceing.ceing.service;

import ceing.ceing.domain.Address;
import ceing.ceing.domain.Member;
import ceing.ceing.exception.DuplicateLoginIdException;
import ceing.ceing.exception.PasswordMismatchException;
import ceing.ceing.repository.MemberRepository;
import ceing.ceing.web.dto.MemberSaveDto;
import ceing.ceing.web.dto.MemberUpdateDto;
import java.util.List;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@Service
@Transactional(readOnly = true)
@Slf4j
@RequiredArgsConstructor
public class MemberService {


    private final MemberRepository memberRepository;

    /**
     * 회원 가입
     * 1. 입력한 아이디가 중복인지
     * 2. 위 비밀번호 = 아래 비밀번호 여부
     */
    @Transactional
    public void join(MemberSaveDto memberSaveDto){
         //회원가입 시 1. 아이디 중복 체크  2. 비밀번호 8자리 및 특수문자 포함? 3.
        String loginId = memberSaveDto.getLoginId();
        //id로 찾았는데 하나라도 있다면 예외 발생 !!
        memberRepository.findByLoginId(loginId).orElseThrow(()->new DuplicateLoginIdException("이미 존재하는 ID입니다."));
        String password = memberSaveDto.getPassword();
        String rePassword = memberSaveDto.getRePassword();
        if (!password.equals(rePassword)){
            throw new PasswordMismatchException("비밀번호를 한번 더 확인해주세요");
        }
        String username = memberSaveDto.getUsername();
        Address address = memberSaveDto.getAddress();
        String phoneNumber = memberSaveDto.getPhoneNumber();
        Member member = new Member(username, address, phoneNumber , loginId , password);
        memberRepository.save(member);

    }

    /**
     * 로그인 정보를 제외한 회원 정보(이름 , 폰번호 , 주소)만 수정
     */
    @Transactional
    public void updateMember(Long memberId , MemberUpdateDto memberUpdateDto){
        Member updateMember = memberRepository.findById(memberId).orElseThrow();
        updateMember.changeMemberInfo(memberUpdateDto.getUsername() , memberUpdateDto.getAddress() , memberUpdateDto.getPhoneNumber());
        //setter 지양 설계 ㅇㅇ
    }


    /**
     * 회원 로그인
     */
    public Member login(String loginId , String password){
        List<Member> findMembers = memberRepository.findAll();
        return validateAuthenticateMember(loginId, password, findMembers);
    }


    /**
     * 로그인 id로 회원 조회
     */
    public Member findByLoginId(String loginId){
        return memberRepository.findByLoginId(loginId).orElse(null);
    }

    /**
     * 회원 검증
     */
    private static Member validateAuthenticateMember(String loginId, String password, List<Member> findMembers) {
        return findMembers.stream()
            .filter(member -> member.getLoginId().equals(loginId) && member.getPassword()
                .equals(password))
            .findAny().orElse(null);
    }



}
