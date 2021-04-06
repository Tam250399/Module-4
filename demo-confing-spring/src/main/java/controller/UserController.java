package controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
@RequestMapping("/users")
public class UserController {

    @PostMapping("/login")
    public String login (@ModelAttribute("username") String name, @ModelAttribute("pass") String pass){
        if(name.equals("admin")&& pass.equals("123")){
            return "/product/list";
        }
        return "/user/login";
    }

    @GetMapping("/login")
    public String login(){
        return "user/login";
    }

}
