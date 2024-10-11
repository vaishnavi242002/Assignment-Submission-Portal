package com.example.website.Assignment.controller;



import com.example.website.Assignment.model.Assignment;
import com.example.website.Assignment.service.AssignmentService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RestController
public class AssignmentController {

    @Autowired
    private AssignmentService assignmentService;

    @GetMapping("/assignments")
    public ResponseEntity<List<Assignment>> getAssignments() {
        List<Assignment> assignments = assignmentService.getAllAssignments(); // Modify this method as needed to retrieve all assignments
        return ResponseEntity.ok(assignments);
    }

    @PostMapping("/assignments/{id}/accept")
    public ResponseEntity<String> acceptAssignment(@PathVariable String id) {
        Optional<Assignment> assignmentOpt = assignmentService.getAssignmentById(id);
        if (!assignmentOpt.isPresent()) {
            return ResponseEntity.badRequest().body("Assignment not found.");
        }
        Assignment assignment = assignmentOpt.get();

        // Update status to accepted
        assignment.setStatus("accepted");
        assignmentService.updateAssignment(assignment);
        return ResponseEntity.ok("Assignment accepted.");
    }

    
    @PostMapping("/assignments/{id}/reject")
    public ResponseEntity<String> rejectAssignment(@PathVariable String id) {
        Optional<Assignment> assignmentOpt = assignmentService.getAssignmentById(id);
        if (!assignmentOpt.isPresent()) {
            return ResponseEntity.badRequest().body("Assignment not found.");
        }
        Assignment assignment = assignmentOpt.get();

        assignment.setStatus("rejected");
        assignmentService.updateAssignment(assignment);
        return ResponseEntity.ok("Assignment rejected.");
    }
}
