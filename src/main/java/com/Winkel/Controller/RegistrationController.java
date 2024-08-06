package com.Winkel.Controller;

import com.Winkel.Model.User;
import com.Winkel.Repository.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class RegistrationController {
    @Autowired
    public UserRepository userRepository;
    @Autowired
     public PasswordEncoder passwordEncoder;

    @PostMapping(value = "/signup", consumes = "application/json")
    public User createUser(@RequestBody User user){
        user.setPassword(passwordEncoder.encode(user.getPassword()));
    return userRepository.save(user);
    }
}
