package ceing.ceing.web.controller;


import ceing.ceing.domain.Member;
import ceing.ceing.web.login.Login;
import ceing.ceing.web.login.LoginDto;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpSession;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.SessionAttribute;

@Controller
@Slf4j
public class HomeController {

    @GetMapping
    public String homeController(@Login Member loginMember , Model model){
        model.addAttribute("member" , loginMember);
        return "home";
        //클라이언트단에서 판독할래 서버단에서 판독할래 차이?
        /*if (loginMember == null){
            return "home";
        }*/


    }




}
