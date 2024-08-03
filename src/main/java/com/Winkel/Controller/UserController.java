package com.Winkel.Controller;

import com.Winkel.Model.User;
import com.Winkel.Repository.UserRepository;
import com.Winkel.Service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

@Controller
public class UserController {

    @Autowired
    private UserService userService;

    @Autowired
    private UserRepository userRepository;

    @Autowired
    private PasswordEncoder passwordEncoder;

    @GetMapping("/login")
    public String loginPage(){
        return "login.html";
    }

    @PostMapping("/login")
    public String loginForm(@RequestParam String username, @RequestParam String password){
        return "redirect:/home";
    }

    @GetMapping("/signup")
    public String signPage(){
        return "signup.html";
    }

    @PostMapping("/signup")
    public String createUser(@RequestParam String name,@RequestParam String username, @RequestParam String email, @RequestParam String password, Model model){
        return "redirect:/login";
    }
}
