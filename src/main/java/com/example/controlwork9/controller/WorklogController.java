package com.example.controlwork9.controller;

import com.example.controlwork9.dto.WorklogDto;
import com.example.controlwork9.mapper.WorklogMapper;
import com.example.controlwork9.service.WorklogService;
import lombok.AllArgsConstructor;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.multipart.MultipartFile;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.List;
import java.util.stream.Collectors;

@AllArgsConstructor
@RestController
public class WorklogController {
    final private WorklogMapper worklogMapper;
    final private WorklogService worklogService;

    @GetMapping("worklogs")
    public List<WorklogDto> getAllById(@RequestParam(value = "id") Long id) {
        return worklogService.getWorklogsById(id)
                .stream()
                .map(worklogMapper::fromWorklog)
                .collect(Collectors.toList());
    }

    @PostMapping("work-save")
    public void saveWorklog(@RequestParam(value = "id") Long id,
                            @RequestParam(value = "description") String desc,
                            @RequestParam(value = "time") String time) {
        worklogService.saveWorklog(id, desc, time);
    }

    @PostMapping("status")
    public void saveStatus(@RequestParam(value = "name") String name) {
        if (name.equals("failed")) {
            worklogService.saveStatus(name);
        }
    }

    @PostMapping("upload-files")
    private void uploadFile(@RequestParam("file") MultipartFile file, @RequestParam("id") Long taskId) {
        worklogService.addFile(file.getOriginalFilename(), taskId);
        byte[] data;
        String fileName = file.getOriginalFilename();
        Path path = Paths.get("src/main/resources/static/" + fileName);
        try {
            data = file.getBytes();
            Files.write(path, data);
        } catch (
                IOException e) {
            e.printStackTrace();
        }
    }
}