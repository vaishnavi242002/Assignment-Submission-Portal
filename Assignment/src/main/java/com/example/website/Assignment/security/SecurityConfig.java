package com.example.website.Assignment.security;

import com.example.website.Assignment.service.CustomUserDetailsService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.config.annotation.authentication.builders.AuthenticationManagerBuilder;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.security.web.SecurityFilterChain;

@Configuration
@EnableWebSecurity
public class SecurityConfig {

    @Autowired
    private CustomUserDetailsService userDetailsService;

    @Bean
    public PasswordEncoder passwordEncoder() {
        return new BCryptPasswordEncoder();
    }

    @Bean
    public AuthenticationManager authenticationManager(HttpSecurity http, PasswordEncoder passwordEncoder)
      throws Exception {
        return http.getSharedObject(AuthenticationManagerBuilder.class)
          .userDetailsService(userDetailsService)
          .passwordEncoder(passwordEncoder)
          .and()
          .build();
    }

    
    @Bean
    public SecurityFilterChain filterChain(HttpSecurity http) throws Exception {
        http
            .csrf().disable() 
            .authorizeHttpRequests()
            
                .requestMatchers("/register", "/login", "/admins").permitAll()
                .requestMatchers("/upload").hasRole("USER")

        
                .requestMatchers("/admin/register", "/admin/login", "/assignments").permitAll()
                
                
                .requestMatchers("/assignments/{id}/accept").permitAll()
                
              
                .requestMatchers("/assignments/{id}/reject").permitAll()
                .requestMatchers("/admin/users").permitAll()
                .requestMatchers("/assignments/**").hasRole("ADMIN")
            
                .anyRequest().authenticated()
            .and()
                .httpBasic(); 

        return http.build();
    }
}
