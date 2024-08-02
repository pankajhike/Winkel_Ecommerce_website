package com.Winkel.Config;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.web.SecurityFilterChain;
import org.springframework.security.web.authentication.UsernamePasswordAuthenticationFilter;

@Configuration
@EnableWebSecurity
public class ProjectSecurityConfig {

    @Bean
    public SecurityFilterChain securityFilterChain(HttpSecurity httpSecurity) throws Exception {
        return httpSecurity
                .authorizeRequests(authz -> authz
                        .requestMatchers("/admin/**").hasRole("ADMIN") // Example: Admin access
                        .requestMatchers("/user/**","/css","/fonts","/js","/img","/sass","/Source").hasRole("USER") // Example: User access
                        .anyRequest().authenticated() // All other requests require authentication
                )
                .formLogin(formLogin -> formLogin
                        .loginPage("/login") // Specify custom login page URL
                        .permitAll() // Allow everyone to access the login page
                )
                .logout(logout -> logout
                        .logoutUrl("/logout") // Specify logout URL
                        .logoutSuccessUrl("/login?logout") // Redirect after logout
                        .permitAll() // Allow everyone to access the logout functionality
                )
                .csrf(csrf -> csrf.disable()) // Optional: Disable CSRF protection (useful for development/testing)
                .build();
    }
}
