package com.example.controlwork9.service;

import com.example.controlwork9.repository.TaskRepository;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;

@AllArgsConstructor
@Service
public class TaskService {
    final private TaskRepository taskRepository;
}
