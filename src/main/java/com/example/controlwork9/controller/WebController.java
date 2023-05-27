package com.example.controlwork9.controller;

import lombok.AllArgsConstructor;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

@Controller
@AllArgsConstructor
@RequestMapping("/")
public class WebController {
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
