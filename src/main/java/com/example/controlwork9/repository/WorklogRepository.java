package com.example.controlwork9.repository;

import com.example.controlwork9.entity.Worklog;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import java.util.List;

public interface WorklogRepository extends JpaRepository<Worklog, Long> {
    @Query("select w from Worklog as w where w.task.id = :id")
    List<Worklog> findWorkById(Long id);
}
