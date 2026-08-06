package com.projectaurora.backend.service.impl;

import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

import com.projectaurora.backend.dto.auth.AuthResponse;
import com.projectaurora.backend.dto.auth.LoginRequest;
import com.projectaurora.backend.dto.auth.RegisterRequest;
import com.projectaurora.backend.entity.User;
import com.projectaurora.backend.exception.EmailAlreadyExistsException;
import com.projectaurora.backend.repository.RoleRepository;
import com.projectaurora.backend.repository.UserRepository;
import com.projectaurora.backend.repository.UserRoleRepository;
import com.projectaurora.backend.security.JwtService;
import com.projectaurora.backend.service.AuthenticationService;

import lombok.RequiredArgsConstructor;

@Service
@RequiredArgsConstructor
public class AuthenticationServiceImpl implements AuthenticationService {

    private final UserRepository userRepository;
    private final RoleRepository roleRepository;
    private final UserRoleRepository userRoleRepository;

    private final PasswordEncoder passwordEncoder;
    private final JwtService jwtService;
    private final AuthenticationManager authenticationManager;

    @Override
    public AuthResponse register(RegisterRequest request) {

        // Check whether the email is already registered
        if (userRepository.existsByEmail(request.getEmail())) {
            throw new EmailAlreadyExistsException(
                    "Email already registered: " + request.getEmail());
        }

        // Create the user
        User user = User.builder()
                .firstName(request.getFirstName())
                .lastName(request.getLastName())
                .email(request.getEmail())
                .passwordHash(passwordEncoder.encode(request.getPassword()))
                .active(true)
                .emailVerified(false)
                .build();

        // Save the user
        userRepository.save(user);

        // Remaining implementation:
        // 1. Fetch STUDENT role
        // 2. Save UserRole
        // 3. Generate JWT
        // 4. Return AuthResponse

        throw new UnsupportedOperationException(
                "Role assignment and JWT generation not implemented yet");
    }

    @Override
    public AuthResponse login(LoginRequest request) {

        throw new UnsupportedOperationException(
                "Login not implemented yet");
    }
}