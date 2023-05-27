package com.example.controlwork9.repository;

import com.example.controlwork9.entity.Task;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import java.util.List;

public interface TaskRepository extends JpaRepository<Task, Long> {
    @Query("select t from Task as t where t.status.status like :name")
    List<Task> getTasksByNamePage(Pageable pageable, String name);

    @Query("select t from Task as t")
    List<Task> findAllTasks(Pageable pageable);
}
