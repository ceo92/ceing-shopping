package ceing.ceing.web;


import ceing.ceing.domain.Member;
import ceing.ceing.web.loginannotation.Login;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;

@Controller
@Slf4j
public class HomeController {

    @GetMapping
    public String homeController(@Login Member loginMember , Model model){
        model.addAttribute("member" , loginMember);
        return "index";
        //클라이언트단에서 판독할래 서버단에서 판독할래 차이?

        /*if (loginMember == null){
            return "home";
        }
        */
    }




}
