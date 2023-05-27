package com.example.controlwork9.dto;

import lombok.Builder;
import lombok.Data;

import java.time.LocalDateTime;

@Data
@Builder
public class TaskDto {
    private String name;
    private LocalDateTime created;
    private String attachments;
    private String username;
    private String status;
    private String worklog;
    private Long id;
}
