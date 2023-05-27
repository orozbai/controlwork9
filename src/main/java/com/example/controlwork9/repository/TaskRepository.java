package com.example.controlwork9.repository;

import com.example.controlwork9.entity.Task;
import org.springframework.data.jpa.repository.JpaRepository;

public interface TaskRepository extends JpaRepository<Task, Long> {
}
