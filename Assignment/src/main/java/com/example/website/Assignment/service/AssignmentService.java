

package com.example.website.Assignment.service;

import com.example.website.Assignment.model.Assignment;
import com.example.website.Assignment.repository.AssignmentRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class AssignmentService {

    @Autowired
    private AssignmentRepository assignmentRepository;

  
    public Assignment createAssignment(Assignment assignment) {
        return assignmentRepository.save(assignment);
    }

    public Optional<Assignment> getAssignmentById(String id) {
        return assignmentRepository.findById(id);
    }

    
    public List<Assignment> getAllAssignments() {
        return assignmentRepository.findAll(); 
    }

    
    public List<Assignment> getAssignmentsByAdmin(String admin) {
        return assignmentRepository.findByAdmin(admin); 
    }

   
    public Assignment updateAssignment(Assignment assignment) {
        return assignmentRepository.save(assignment);
    }

}
