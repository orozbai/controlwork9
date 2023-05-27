package com.example.controlwork9.controller;

import com.example.controlwork9.dto.UserRegistrationDto;
import com.example.controlwork9.service.UserService;
import lombok.AllArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

@Controller
@AllArgsConstructor
@RequestMapping("/")
public class WebController {
    final private UserService userService;

    @GetMapping()
    public String getMainPage() {
        return "main";
    }

    @GetMapping("manager")
    public String getManager() {
        return "manager";
    }

    @GetMapping("logout")
    public String logoutGet() {
        SecurityContextHolder.clearContext();
        return "redirect:/login";
    }

    @GetMapping("register")
    public String register() {
        return "register";
    }

    @PostMapping("register")
    public ResponseEntity<?> registerUser(@RequestBody UserRegistrationDto registrationDto) {
        userService.registerUser(registrationDto);
        return ResponseEntity.ok("Вы успешно зарегестрировались!");
    }
    @GetMapping("worklog")
    public String workLog() {
        return "worklog";
    }


    @PostMapping("logout")
    public String logout() {
        SecurityContextHolder.clearContext();
        return "redirect:/login";
    }

    @GetMapping("login")
    public String getLogin(@RequestParam(value = "error", required = false) String error,
                           @RequestParam(value = "logout", required = false) String logout,
                           Model model) {
        model.addAttribute("error", error != null);
        model.addAttribute("logout", logout != null);
        return "login";
    }
}
