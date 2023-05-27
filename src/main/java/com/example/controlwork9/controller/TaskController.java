package com.example.controlwork9.controller;

import com.example.controlwork9.service.TaskService;
import lombok.AllArgsConstructor;
import org.springframework.web.bind.annotation.RestController;

@AllArgsConstructor
@RestController
public class TaskController {
    final private TaskService taskService;
}
