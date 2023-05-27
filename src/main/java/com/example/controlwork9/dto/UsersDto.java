package com.example.controlwork9.dto;

import lombok.Builder;
import lombok.Data;

@Data
@Builder
public class UsersDto {
    private String name;
    private Long id;
}
