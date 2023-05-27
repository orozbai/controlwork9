package com.example.controlwork9.controller;

import com.example.controlwork9.service.UserService;
import lombok.AllArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.security.core.annotation.AuthenticationPrincipal;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@AllArgsConstructor
@RestController
@RequestMapping("/user")
public class UserController {
    final private UserService userService;

    @GetMapping("/current-user")
    public ResponseEntity<String> getUser(@AuthenticationPrincipal UserDetails userDetails) {
        if (userDetails != null && userDetails.getUsername() != null && !userDetails.getUsername().isEmpty()) {
            var user = userService.getRoleByEmail(userDetails.getUsername());
            return ResponseEntity.ok("{\"user\":\"" + user + "\"}");
        } else {
            return ResponseEntity.ok("{\"error\":\"Пользователь не авторизован\"}");
        }
    }

}
