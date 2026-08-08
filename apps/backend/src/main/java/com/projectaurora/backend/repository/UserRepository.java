package com.projectaurora.backend.repository;

import java.util.Optional;

import org.springframework.data.jpa.repository.EntityGraph;
import org.springframework.data.jpa.repository.JpaRepository;

import com.projectaurora.backend.entity.User;

public interface UserRepository extends JpaRepository<User, Long> {

    boolean existsByEmail(String email);

    @EntityGraph(attributePaths = {
            "userRoles",
            "userRoles.role"
    })
    Optional<User> findByEmail(String email);
}