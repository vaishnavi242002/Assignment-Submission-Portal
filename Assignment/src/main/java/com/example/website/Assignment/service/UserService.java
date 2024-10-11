package com.example.website.Assignment.service;


import com.example.website.Assignment.model.User;
import com.example.website.Assignment.repository.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class UserService {

    @Autowired
    private UserRepository userRepository;


    public void registerUser(User user) {
        userRepository.save(user);
    }
    
   

    public Optional<User> findByUsername(String username) {
        return userRepository.findByUsername(username);
    }
}
