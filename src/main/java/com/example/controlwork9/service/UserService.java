package com.example.controlwork9.service;

import com.example.controlwork9.entity.User;
import com.example.controlwork9.repository.UserRepository;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;

@AllArgsConstructor
@Service
public class UserService {
    final private UserRepository userRepository;

    public String getRoleByEmail(String username) {
        return userRepository.getRoleByEmail(username);
    }

    public List<User> getUsersName() {
        return userRepository.getUsersName();
    }

    public User getUserById(Long id) {
        return userRepository.findByIdUser(id);
    }
}
