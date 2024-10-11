package com.example.website.Assignment.service;

import com.example.website.Assignment.model.Admin;
import com.example.website.Assignment.repository.AdminRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class AdminService {
 
 @Autowired
 private AdminRepository adminRepository;
 
 @Autowired
 private PasswordEncoder passwordEncoder;

 public void registerAdmin(Admin admin) {
     adminRepository.save(admin);
 }


 public Optional<Admin> findByUsername(String username) {
     return adminRepository.findByUsername(username);
 }

 public List<Admin> findAllAdmins() {
     List<Admin> admins = adminRepository.findAll();
 
//     admins.forEach(admin -> admin.setPassword(null));
     return admins;
 }


}

