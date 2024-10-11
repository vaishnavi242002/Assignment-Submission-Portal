package com.example.website.Assignment.service;

import com.example.website.Assignment.model.Admin;
import com.example.website.Assignment.model.User;
import com.example.website.Assignment.repository.AdminRepository;
import com.example.website.Assignment.repository.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.userdetails.*;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
public class CustomUserDetailsService implements UserDetailsService {

 @Autowired
 private UserRepository userRepository;

 @Autowired
 private AdminRepository adminRepository;

 @Override
 public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
   
     User user = userRepository.findByUsername(username).orElse(null);
     if (user != null) {
         List<GrantedAuthority> authorities = new ArrayList<>();
         authorities.add(new SimpleGrantedAuthority(user.getRole()));
         return new org.springframework.security.core.userdetails.User(
             user.getUsername(),
             user.getPassword(),
             authorities
         );
     }

    
     Admin admin = adminRepository.findByUsername(username).orElse(null);
     if (admin != null) {
         List<GrantedAuthority> authorities = new ArrayList<>();
         authorities.add(new SimpleGrantedAuthority("ROLE_ADMIN"));
         return new org.springframework.security.core.userdetails.User(
             admin.getUsername(),
             admin.getPassword(),
             authorities
         );
     }

     throw new UsernameNotFoundException("User not found with username: " + username);
 }
}

