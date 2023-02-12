package com.example.spartaspring.repository;

import com.example.spartaspring.model.User;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.Optional;

public interface UserRepository extends JpaRepository<User, Long> {
    Optional<User> findByUsername(String username); //스프링 jpa에서 query로 변경해준다
}