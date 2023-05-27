package com.example.controlwork9.service;

import com.example.controlwork9.entity.Status;
import com.example.controlwork9.entity.Task;
import com.example.controlwork9.entity.Worklog;
import com.example.controlwork9.repository.StatusRepository;
import com.example.controlwork9.repository.TaskRepository;
import com.example.controlwork9.repository.WorklogRepository;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.time.LocalDateTime;
import java.util.List;

@Service
@AllArgsConstructor
public class WorklogService {
    final private WorklogRepository worklogRepository;
    final private TaskRepository taskRepository;
    final private StatusRepository statusRepository;

    public List<Worklog> getWorklogsById(Long id) {
        return worklogRepository.findWorkById(id);
    }

    public void saveWorklog(Long id, String desc, String time) {
        Task task = taskRepository.findTaskById(id);
        LocalDateTime dateTime = LocalDateTime.now();
        Worklog worklog = Worklog.builder()
                .created(dateTime)
                .description(desc)
                .time(time)
                .task(task)
                .build();
        worklogRepository.save(worklog);
    }

    public void saveStatus(String name) {
        Status status = statusRepository.findByName(name);
        taskRepository.updateStatus(status);
    }

    @Transactional
    public void addFile(String originalFilename, Long taskId) {
        taskRepository.updateWorkLog(originalFilename, taskId);
    }
}
