package com.projectaurora.backend.repository;

import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.projectaurora.backend.entity.Role;
import com.projectaurora.backend.enums.RoleType;

@Repository
public interface RoleRepository extends JpaRepository<Role, Short> {

    Optional<Role> findByRoleName(RoleType roleName);

}