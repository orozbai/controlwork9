package com.example.controlwork9.service;

import com.example.controlwork9.entity.Status;
import com.example.controlwork9.entity.Task;
import com.example.controlwork9.entity.User;
import com.example.controlwork9.repository.TaskRepository;
import lombok.AllArgsConstructor;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

import java.time.LocalDateTime;
import java.util.List;

@AllArgsConstructor
@Service
public class TaskService {
    final private TaskRepository taskRepository;
    final private UserService userService;
    final private StatusService service;

    public List<Task> getTasksPageableToMain(Pageable pageable, String name) {
        return taskRepository.getTasksByNamePage(pageable, name);
    }

    public List<Task> getAllTasks(Pageable pageable) {
        return taskRepository.findAllTasks(pageable);
    }

    public void saveTask(String name, Long id, LocalDateTime time) {
        User user = userService.getUserById(id);
        Status status = service.getByName();
        Task task = Task.builder()
                .name(name)
                .attachments("link")
                .status(status)
                .created(time)
                .user(user)
                .build();
        taskRepository.save(task);
    }

    public String getFileById(Long id) {
        return taskRepository.getFileById(id);
    }
}
