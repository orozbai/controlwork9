package com.example.controlwork9.service;

import com.example.controlwork9.repository.UserRepository;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;

@AllArgsConstructor
@Service
public class UserService {
    final private UserRepository userRepository;

    public String getRoleByEmail(String username) {
        return userRepository.getRoleByEmail(username);
    }
}
