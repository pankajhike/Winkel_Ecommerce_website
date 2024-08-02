package com.Winkel.Controller;

import com.Winkel.Model.User;
import com.Winkel.Repository.userRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.security.web.authentication.logout.SecurityContextLogoutHandler;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

@Controller
public class LoginController {
    @Autowired
    private userRepository userRepository;

    @RequestMapping(value = "/login", method = {RequestMethod.GET,RequestMethod.POST})
    public String loginPage(@RequestParam(value = "error",required = false) String error, @RequestParam(value = "logout",required = false) String logout, Model model){

        String errorMessage=null;
        if (error != null){
            errorMessage="Username or Password is incorrect !!";
        }
        if(logout != null){
            errorMessage = "You have been Successfully Logded out !!";
        }
        model.addAttribute("errorMessage", errorMessage);
        return "login.html";
    }
//    @RequestMapping(value = "/logout",method = RequestMethod.GET)
//    public String logoutPage(HttpServletRequest request, HttpServletResponse response){
//        Authentication auth = SecurityContextHolder.getContext().getAuthentication();
//        if (auth != null){
//            new SecurityContextLogoutHandler().logout(request,response,auth);
//        }
//        return "redirect:/login?logout=true";
//    }
    @RequestMapping("/signup")
    public String signupPage(){
        return "signup.html";
    }

    @Autowired
    private PasswordEncoder passwordEncoder;
    @PostMapping("/register/user")
    public User createUser(@RequestBody User user){
        user.setPassword(passwordEncoder.encode(user.getPassword()));
        return userRepository.save(user);
    }
}
