

package com.example.website.Assignment.repository;

import com.example.website.Assignment.model.Admin;
//src/main/java/com/example/website/AssignmentPortal/repository/AdminRepository.java


import org.springframework.data.mongodb.repository.MongoRepository;

import java.util.Optional;

public interface AdminRepository extends MongoRepository<Admin, String> {
 Optional<Admin> findByUsername(String username);
}

