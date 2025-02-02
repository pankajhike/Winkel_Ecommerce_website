package com.Winkel.Config;

import com.Winkel.Service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.authentication.AuthenticationProvider;
import org.springframework.security.authentication.dao.DaoAuthenticationProvider;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.security.web.SecurityFilterChain;

@Configuration
@EnableWebSecurity
public class SecurityConfig {

    @Autowired
    private UserService userService;

    @Bean
    public UserDetailsService userDetailsService() {
        return userService;
    }

    @Bean
    public AuthenticationProvider authenticationProvider() {
        DaoAuthenticationProvider provider = new DaoAuthenticationProvider();
        provider.setUserDetailsService(userService);
        provider.setPasswordEncoder(passwordEncoder());
        return provider;
    }

    @Bean
    public PasswordEncoder passwordEncoder() {
        return new BCryptPasswordEncoder();
    }

    @Bean
    public SecurityFilterChain securityFilterChain(HttpSecurity httpSecurity) throws Exception {
        return httpSecurity
                .csrf(csrf -> csrf.disable())
                .formLogin(login -> {
                    login.loginPage("/login").permitAll();
                    login.defaultSuccessUrl("/home");
                })
                .logout(logout -> {
                    logout.logoutUrl("/logout")
                            .logoutSuccessUrl("/login?logout")
                            .permitAll();
                })
                .authorizeHttpRequests(auth -> {
                    auth.requestMatchers("/signup", "/css/**", "/fonts/**", "/img/**", "/js/**", "/sass/**", "/Sources/**").permitAll();
                    auth.anyRequest().authenticated();
                })
                .build();
    }
}
