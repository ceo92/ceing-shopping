package ceing.ceing.web.member.login;

import ceing.ceing.SessionConst;
import ceing.ceing.domain.Member;
import ceing.ceing.service.MemberService;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpSession;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Controller;
import org.springframework.util.StringUtils;
import org.springframework.validation.BindingResult;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;

/**
 * 로그인 페이지
 */
@Controller
@RequiredArgsConstructor
@Slf4j
public class LoginController {
    /**
     * 로그인 화면 컨트롤러
     */
    private final MemberService memberService;
    @GetMapping("/login")
    public String loginForm(@ModelAttribute("login") LoginDto loginDto){
        return "login";
    }

    @PostMapping("/login")
    public String login(@Validated @ModelAttribute("login") LoginDto loginDto , BindingResult bindingResult , HttpServletRequest request){
        //1. 데이터 유효성 검증
        if (bindingResult.hasErrors()){
            return "login";
        }

        //2. 로그인 검증
        Member loginMember = memberService.login(loginDto.getLoginId() , loginDto.getPassword());
        if (loginMember==null){
            bindingResult.reject("loginFail");
            return "login";
        }

        //3. 로그인 성공
        HttpSession session = request.getSession(true); //있으면 반환 업
        session.setAttribute(SessionConst.MEMBER_NAME , loginMember);
        log.info("session = {}" , session.getAttribute(SessionConst.MEMBER_NAME));
        return "redirect:/";
    }

    /**
     *  로그아웃 컨트롤러
     */
    @PostMapping("/logout")
    public String logout(HttpServletRequest request){
        HttpSession session = request.getSession(false);
        if (session != null){
            session.invalidate();
        }
        return "redirect:/";

    }

    /**
     * 회원가입 컨트롤러
     */
    @GetMapping("/join")
    public String join(@ModelAttribute("member") MemberSaveDto member){
        return "join";
    }


    @PostMapping("/join")
    public String join(@Validated @ModelAttribute("member") MemberSaveDto memberSaveDto , BindingResult bindingResult){
        /**
         * 1. 필드 에러 검증(Bean Validation)
         */

        if (bindingResult.hasErrors()){
            return "join";
        }
        /**
         * 2. 전역 에러 검증(reject())
         */
        //입력한 아이디 중복 여부 체크
        String loginId = memberSaveDto.getLoginId();
        Member findMember = memberService.findByLoginId(loginId);
        if (findMember != null) {
            bindingResult.reject("duplicate");
            return "join";
        }

        //비밀번호 일치여부 체크
        String rePassword = memberSaveDto.getRePassword();
        String password = memberSaveDto.getPassword();
        if (!password.equals(rePassword)){
            bindingResult.reject("pwDoubleCheckFail");
            return "join";
        }

        /**
         * 3. 회원가입 성공 후 자동 로그인
         */
        String username = memberSaveDto.getUsername();
        String address = memberSaveDto.getAddress();
        String phoneNumber = memberSaveDto.getPhoneNumber();

        Member member = new Member(username, address, phoneNumber, loginId, password);
        memberService.save(member);
        return "index";
    }



}
