package com.example.controlwork9.repository;

import com.example.controlwork9.entity.Status;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

public interface StatusRepository extends JpaRepository<Status, Long> {

    @Query("select s from Status as s where s.id = :create")
    Status getByName(Long create);
}
