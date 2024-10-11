

package com.example.website.Assignment.controller;

import com.example.website.Assignment.model.Admin;
import com.example.website.Assignment.model.User;
import com.example.website.Assignment.service.AdminService;
import com.example.website.Assignment.service.UserService;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.security.core.Authentication;
import org.springframework.web.bind.annotation.*;


@RestController
@RequestMapping("/admin")
public class AdminController {

    @Autowired
    private AdminService adminService;

    
    @Autowired
    private UserService userService;
    
  
    
    @GetMapping("/me")
    public ResponseEntity<?> getAdminDetails(Authentication authentication) {
        String adminUsername = authentication.getName();
        Admin admin = adminService.findByUsername(adminUsername).orElse(null);
        if (admin != null) {
            
            admin.setPassword(null);
            return ResponseEntity.ok(admin);
        } else {
            return ResponseEntity.status(404).body("Admin not found.");
        }
    }

    
}
