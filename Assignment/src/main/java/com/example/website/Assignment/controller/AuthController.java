package com.example.website.Assignment.controller;



import com.example.website.Assignment.model.Admin;
import com.example.website.Assignment.model.User;
import com.example.website.Assignment.service.AdminService;
import com.example.website.Assignment.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;


@RestController
public class AuthController {

    @Autowired
    private UserService userService;
    
    @Autowired
    private AdminService adminService;

   
    @PostMapping("/register")
    public ResponseEntity<?> registerUser(@RequestBody User user) {
        if (userService.findByUsername(user.getUsername()).isPresent()) {
            return ResponseEntity.badRequest().body("Username is already taken.");
        }
        userService.registerUser(user);
        return ResponseEntity.ok("User registered successfully.");
    }

   
    @PostMapping("/admin/register")
    public ResponseEntity<?> registerAdmin(@RequestBody Admin admin) {
        if (adminService.findByUsername(admin.getUsername()).isPresent()) {
            return ResponseEntity.badRequest().body("Username is already taken.");
        }
        adminService.registerAdmin(admin);
        return ResponseEntity.ok("Admin registered successfully.");
    }

   
    @PostMapping("/login")
    public ResponseEntity<?> loginUser(@RequestBody User user) {
        User foundUser = userService.findByUsername(user.getUsername())
                .orElse(null);
        if (foundUser != null && foundUser.getPassword().equals(user.getPassword())) {
            return ResponseEntity.ok("User logged in successfully.");
        }
        return ResponseEntity.badRequest().body("Invalid username or password.");
    }

    
    @PostMapping("/admin/login")
    public ResponseEntity<?> loginAdmin(@RequestBody Admin admin) {
        Admin foundAdmin = adminService.findByUsername(admin.getUsername())
                .orElse(null);
        if (foundAdmin != null && foundAdmin.getPassword().equals(admin.getPassword())) {
            return ResponseEntity.ok("Admin logged in successfully.");
        }
        return ResponseEntity.badRequest().body("Invalid username or password.");
    }
}
