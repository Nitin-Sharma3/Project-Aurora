package com.projectaurora.backend.service.impl;

import org.springframework.stereotype.Service;

import com.projectaurora.backend.dto.auth.AuthResponse;
import com.projectaurora.backend.dto.auth.LoginRequest;
import com.projectaurora.backend.dto.auth.RegisterRequest;
import com.projectaurora.backend.repository.RoleRepository;
import com.projectaurora.backend.repository.UserRepository;
import com.projectaurora.backend.repository.UserRoleRepository;
import com.projectaurora.backend.service.AuthenticationService;

import lombok.RequiredArgsConstructor;

@Service
@RequiredArgsConstructor
public class AuthenticationServiceImpl implements AuthenticationService {

    private final UserRepository userRepository;

    private final RoleRepository roleRepository;

    private final UserRoleRepository userRoleRepository;

    @Override
    public AuthResponse register(RegisterRequest request) {

        throw new UnsupportedOperationException("Registration not implemented yet");

    }

    @Override
    public AuthResponse login(LoginRequest request) {

        throw new UnsupportedOperationException("Login not implemented yet");

    }

}