package com.example.controlwork9.mapper;

import com.example.controlwork9.dto.UsersDto;
import com.example.controlwork9.entity.User;
import org.springframework.stereotype.Component;

@Component
public class UserMapper {
    public UsersDto fromUser(User user) {
        return UsersDto.builder()
                .name(user.getName())
                .id(user.getId())
                .build();
    }
}
