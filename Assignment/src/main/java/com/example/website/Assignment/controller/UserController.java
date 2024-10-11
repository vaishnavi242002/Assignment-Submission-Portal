

package com.example.website.Assignment.controller;

import com.example.website.Assignment.model.Admin;
import com.example.website.Assignment.model.Assignment;
import com.example.website.Assignment.model.AssignmentRequest;
import com.example.website.Assignment.service.AdminService;
import com.example.website.Assignment.service.AssignmentService;

import jakarta.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.security.core.Authentication;
import org.springframework.web.bind.annotation.*;


import java.util.List;

@RestController
public class UserController {

    @Autowired
    private AssignmentService assignmentService;

    @Autowired
    private AdminService adminService;

   
    @PostMapping("/upload")
    public ResponseEntity<?> uploadAssignment(@Valid @RequestBody AssignmentRequest assignmentRequest, Authentication authentication) {
      
        Assignment assignment = new Assignment();
        assignment.setTask(assignmentRequest.getTask());
        assignment.setAdmin(assignmentRequest.getAdmin());
        assignment.setUserId(authentication.getName()); 
        assignment.setStatus("pending"); 

   
        assignmentService.createAssignment(assignment);

        return ResponseEntity.ok("Assignment uploaded successfully.");
    }

   
    @GetMapping("/admins")
    public ResponseEntity<?> getAllAdmins() {
        List<Admin> admins = adminService.findAllAdmins();
        return ResponseEntity.ok(admins);
    }
}
