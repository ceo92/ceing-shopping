package ceing.ceing.web;

import ceing.ceing.SessionConst;
import ceing.ceing.domain.Address;
import ceing.ceing.domain.Member;
import ceing.ceing.exception.DuplicateLoginIdException;
import ceing.ceing.exception.PasswordMismatchException;
import ceing.ceing.service.MemberService;
import ceing.ceing.web.dto.MemberLoginDto;
import ceing.ceing.web.dto.MemberSaveDto;
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
import org.springframework.web.bind.annotation.ResponseBody;

/**
 * 로그인 페이지
 */
@Controller
@RequiredArgsConstructor
@Slf4j
public class MemberController {

    private final MemberService memberService;

    /**
     * 로그인 로직
     */
    @GetMapping("/login")
    public String loginForm(@ModelAttribute("login") MemberLoginDto memberLoginDto){
        return "login";
    }

    @PostMapping("/login")
    public String login(@Validated @ModelAttribute("login") MemberLoginDto memberLoginDto, BindingResult bindingResult , HttpServletRequest request){
        //1. 데이터 유효성 검증
        if (bindingResult.hasErrors()){
            return "login";
        }

        //2. 로그인 검증
        try {
            Member loginMember = memberService.login(memberLoginDto.getLoginId(), memberLoginDto.getPassword());

            //2-1. 로그인 성공
            HttpSession session = request.getSession(true); //세션 살아있으면 그거 반환 없으면 새로 세션 생성해서 반환
            session.setAttribute(SessionConst.MEMBER_NAME , loginMember);
            log.info("session = {}" , session.getAttribute(SessionConst.MEMBER_NAME));
            return "redirect:/";
        }catch (IllegalArgumentException e){
            //2-2 로그인 실패
            bindingResult.reject("loginFail");
            return "login";
        }



    }

    /**
     *  로그아웃 로직
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
     * 회원가입 로직
     */
    @GetMapping("/join")
    public String join(@ModelAttribute("member") MemberSaveDto member){
        return "join";
    }


    @PostMapping("/join")
    public String join(@Validated @ModelAttribute("member") MemberSaveDto memberSaveDto , BindingResult bindingResult){
        //필드 에러 검증(Bean Validation)
        if (bindingResult.hasErrors()){
            return "join";
        }
        //ㅅㅂ 비즈니스 로직 서비스에서 쳐 하랬지 ㅡㅡ

        try {
            memberService.join(memberSaveDto);
        }catch (DuplicateLoginIdException e){
            bindingResult.reject("duplicate");
            return "join";
        }catch (PasswordMismatchException e){
            bindingResult.reject("pwDoubleCheckFail");
            return "join";
        }

        return "index";
    }



}
