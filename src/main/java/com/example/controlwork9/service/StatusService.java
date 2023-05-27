package com.example.controlwork9.service;

import com.example.controlwork9.entity.Status;
import com.example.controlwork9.repository.StatusRepository;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;

@Service
@AllArgsConstructor
public class StatusService {
    final private StatusRepository statusRepository;

    public Status getByName() {
        Long create = 1L;
        return statusRepository.getByName(create);
    }
}
