package com.example.controlwork9.mapper;

import com.example.controlwork9.dto.TaskDto;
import com.example.controlwork9.entity.Task;
import org.springframework.stereotype.Component;

@Component
public class TaskMapper {
    public TaskDto mainPageTasks(Task task) {
        return TaskDto.builder()
                .name(task.getName())
                .id(task.getId())
                .status(task.getStatus().getStatus())
                .username(task.getUser().getUsername())
                .build();
    }
}
