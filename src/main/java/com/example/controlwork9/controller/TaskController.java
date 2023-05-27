package com.example.controlwork9.controller;

import com.example.controlwork9.dto.TaskDto;
import com.example.controlwork9.mapper.TaskMapper;
import com.example.controlwork9.service.TaskService;
import lombok.AllArgsConstructor;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

@AllArgsConstructor
@RestController
public class TaskController {
    final private TaskService taskService;
    final private TaskMapper taskMapper;

    @GetMapping("/tasks")
    public List<TaskDto> getTasks(@RequestParam(required = false, value = "name") String name,
                                  @RequestParam(value = "page", defaultValue = "0") int page,
                                  @RequestParam(required = false, defaultValue = "4") int size) {
        Pageable pageable = PageRequest.of(page, size);
        if (name != null) {
            return taskService.getTasksPageableToMain(pageable, name)
                    .stream()
                    .map(taskMapper::mainPageTasks)
                    .collect(Collectors.toList());
        } else {
            return taskService.getAllTasks(pageable)
                    .stream()
                    .map(taskMapper::mainPageTasks)
                    .collect(Collectors.toList());
        }
    }

    @PostMapping("/save-task")
    public void saveTask(@RequestParam(value = "name") String name,
                         @RequestParam(value = "id") Long id) {
        LocalDateTime time = LocalDateTime.now();
        taskService.saveTask(name, id, time);
    }
}
