package com.Winkel.Controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
public class HomeController {
    @RequestMapping(value = {"", "/", "/home"})
    public String displayHome() {
        return "index.html";
    }
    @GetMapping("/user/home")
    public String userHome(){
        return "index.html";
    }

    @RequestMapping("/shop")
    public String shopPage(){
        return "shop.html";
    }

    @RequestMapping("/contact")
    public String contactPage(){
        return "contact.html";
    }

    @RequestMapping("/blog")
    public String blogPage(){
        return "blog.html";
    }
}
