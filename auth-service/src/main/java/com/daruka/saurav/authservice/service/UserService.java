package com.daruka.saurav.authservice.service;


import com.daruka.saurav.authservice.model.User;
import com.daruka.saurav.authservice.repository.UserRepository;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class UserService {

    private final UserRepository userRepository;

    public UserService(UserRepository userRepository) {
        this.userRepository = userRepository;
    }

    public Optional<User> findByEmail(String email) {
        return userRepository.findByEmail(email);
    }

    public List<User> getUsers() {
        return userRepository.findAll();
    }
}