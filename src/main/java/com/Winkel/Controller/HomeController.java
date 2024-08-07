package com.Winkel.Controller;

import com.Winkel.Model.Contact;
import com.Winkel.Service.ContactService;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.servlet.ModelAndView;

@Controller
public class HomeController {

    @GetMapping("/about")
    public String aboutPage(){
        return "about.html";
    }
    @GetMapping("/blog")
    public String blogPage(){
        return "blog.html";
    }
    @GetMapping("/blog/blog-details")
    public String blogDetailsPage(){
        return "blog-details.html";
    }
    @GetMapping("/contact")
    public String contactPage(){
        return "contact.html";
    }
    @GetMapping("/shop")
    public String shopPage(){
        return "shop.html";
    }

}
