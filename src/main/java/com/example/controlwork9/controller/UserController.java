package com.example.controlwork9.controller;

import com.example.controlwork9.dto.UsersDto;
import com.example.controlwork9.mapper.UserMapper;
import com.example.controlwork9.service.UserService;
import lombok.AllArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.security.core.annotation.AuthenticationPrincipal;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;
import java.util.stream.Collectors;

@AllArgsConstructor
@RestController
@RequestMapping("/user")
public class UserController {
    final private UserService userService;
    final private UserMapper userMapper;

    @GetMapping("/current-user")
    public ResponseEntity<String> getUser(@AuthenticationPrincipal UserDetails userDetails) {
        if (userDetails != null && userDetails.getUsername() != null && !userDetails.getUsername().isEmpty()) {
            var user = userService.getRoleByEmail(userDetails.getUsername());
            return ResponseEntity.ok("{\"user\":\"" + user + "\"}");
        } else {
            return ResponseEntity.ok("{\"error\":\"Пользователь не авторизован\"}");
        }
    }

    @GetMapping("/get-users")
    public List<UsersDto> getUsers() {
        return userService.getUsersName()
                .stream()
                .map(userMapper::fromUser)
                .collect(Collectors.toList());
    }

}
