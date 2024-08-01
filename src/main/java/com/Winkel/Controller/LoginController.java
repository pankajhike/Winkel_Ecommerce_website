package com.Winkel.Controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
public class LoginController {

    @RequestMapping("/login")
    public String loginPage(){

        return "login.html";
    }


    @RequestMapping("/signup")
    public String signupPage(){

        return "signup.html";
    }
}
