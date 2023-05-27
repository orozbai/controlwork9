package com.example.controlwork9.repository;

import com.example.controlwork9.entity.User;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import java.util.List;

public interface UserRepository extends JpaRepository<User, Long> {

    @Query("select u.role from User as u where u.email like :username")
    String getRoleByEmail(String username);

    @Query("select u from User as u")
    List<User> getUsersName();

    @Query("select u from User as u where u.id = :id")
    User findByIdUser(Long id);
}
