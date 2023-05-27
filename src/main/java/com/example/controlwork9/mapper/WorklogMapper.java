package com.example.controlwork9.mapper;

import com.example.controlwork9.dto.WorklogDto;
import com.example.controlwork9.entity.Worklog;
import org.springframework.stereotype.Component;

@Component
public class WorklogMapper {
    public WorklogDto fromWorklog(Worklog worklog) {
        return WorklogDto.builder()
                .created(worklog.getCreated())
                .description(worklog.getDescription())
                .time(worklog.getTime())
                .build();
    }
}
