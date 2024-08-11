package ceing.ceing.web.controller;


import ceing.ceing.domain.Member;
import ceing.ceing.web.constraintannotation.login.Login;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
@Slf4j
public class HomeController {

    @RequestMapping
    public String homeController(@Login Member loginMember , Model model){
        /*if (loginMember == null){ //Member이 null이면 index로 이동 아니면 member 에 loginmember을 담아서 index로 이동
            return "index";
        }*/

        model.addAttribute("member" , loginMember);
        return "index";
        //클라이언트단에서 판독할래 서버단에서 판독할래 차이?
    }




}
