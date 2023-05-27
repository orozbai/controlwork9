package com.example.controlwork9.dto;

import lombok.Builder;
import lombok.Data;

import java.time.LocalDateTime;

@Data
@Builder
public class WorklogDto {
    private String time;
    private String description;
    private LocalDateTime created;
}
