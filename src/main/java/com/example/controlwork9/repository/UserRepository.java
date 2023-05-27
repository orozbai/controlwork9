package com.example.controlwork9.repository;

import com.example.controlwork9.entity.User;
import org.springframework.data.jpa.repository.JpaRepository;

public interface UserRepository extends JpaRepository<User, Long> {
}
