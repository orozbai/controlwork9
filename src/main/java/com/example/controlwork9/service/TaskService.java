package com.example.controlwork9.service;

import com.example.controlwork9.entity.Task;
import com.example.controlwork9.repository.TaskRepository;
import lombok.AllArgsConstructor;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

import java.util.List;

@AllArgsConstructor
@Service
public class TaskService {
    final private TaskRepository taskRepository;

    public List<Task> getTasksPageableToMain(Pageable pageable, String name) {
        return taskRepository.getTasksByNamePage(pageable, name);
    }

    public List<Task> getAllTasks(Pageable pageable) {
        return taskRepository.findAllTasks(pageable);
    }
}
