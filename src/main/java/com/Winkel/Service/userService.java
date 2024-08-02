package com.Winkel.Service;

import com.Winkel.Model.User;
import com.Winkel.Repository.userRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.stereotype.Service;

import java.util.Optional;
import java.util.List;
import java.util.stream.Collectors;
import java.util.Arrays;

@Service
public class userService implements UserDetailsService {

    @Autowired
    private userRepository repository;

    @Override
    public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
        Optional<User> optionalUser = repository.findByUsername(username);
        if (optionalUser.isPresent()) {
            User userObj = optionalUser.get();
            return org.springframework.security.core.userdetails.User.builder()
                    .username(userObj.getUsername())
                    .password(userObj.getPassword())
                    .authorities(getAuthorities(userObj)) // Use authorities instead of roles
                    .build();
        } else {
            throw new UsernameNotFoundException("User not found: " + username);
        }
    }

    private List<SimpleGrantedAuthority> getAuthorities(User user) {
        if (user.getRole() == null || user.getRole().isEmpty()) {
            return List.of(new SimpleGrantedAuthority("ROLE_USER"));
        }
        return Arrays.stream(user.getRole().split(","))
                .map(role -> "ROLE_" + role) // Prefix roles with "ROLE_"
                .map(SimpleGrantedAuthority::new)
                .collect(Collectors.toList());
    }
}
