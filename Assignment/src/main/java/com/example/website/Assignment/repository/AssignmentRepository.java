

package com.example.website.Assignment.repository;

import com.example.website.Assignment.model.Assignment;
import org.springframework.data.mongodb.repository.MongoRepository;

import java.util.List;

public interface AssignmentRepository extends MongoRepository<Assignment, String> {
    List<Assignment> findByAdmin(String admin); 

    List<Assignment> findByUserId(String userId); 

    List<Assignment> findAll(); 
}
