package com.Winkel.Controller;

import com.Winkel.Model.User;
import com.Winkel.Repository.UserRepository;
import jakarta.persistence.GeneratedValue;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

import java.util.Optional;

@Controller
public class LoginController {

    @GetMapping("/login")
    public String loginForm(){
        return "login.html";
    }

    @GetMapping("/signup")
    public String signupForm(){
        return "signup.html";
    }
    @GetMapping("/admin")
    public String adminPage(){
        return "admin.html";
    }

    @GetMapping("/home")
    public String homePage(){
        return "index.html";
    }
}
