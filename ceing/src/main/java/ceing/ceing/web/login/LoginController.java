package ceing.ceing.web.login;

import ceing.ceing.SessionConst;
import ceing.ceing.domain.Member;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpSession;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Controller;
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
public class LoginController {
    /**
     * 로그인 화면 컨트롤러
     */
    private final LoginService loginService;
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
        Member loginMember = loginService.login(loginDto.getLoginId() , loginDto.getPassword());
        if (loginMember==null){
            bindingResult.reject("loginFail");
            return "login";
        }

        //3. 로그인 성공
        HttpSession session = request.getSession(true); //있으면 반환 업
        session.setAttribute(SessionConst.MEMBER_NAME , loginMember);
        return "redirect:/";
    }

    @PostMapping("/logout")
    public String logout(HttpServletRequest request){
        HttpSession session = request.getSession(false);
        if (session != null){
            session.invalidate();
        }
        return "redirect:/";

    }

    @GetMapping("/join")
    public String join(@ModelAttribute Member member){
        return "join";
    }


    @PostMapping("/join")
    public String join(@Validated @ModelAttribute("member") MemberSaveDto memberSaveDto , BindingResult bindingResult){

    }



}
