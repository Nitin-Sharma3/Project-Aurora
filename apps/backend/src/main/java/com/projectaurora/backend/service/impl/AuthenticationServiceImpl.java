package com.projectaurora.backend.service.impl;

import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

import com.projectaurora.backend.dto.auth.AuthResponse;
import com.projectaurora.backend.dto.auth.LoginRequest;
import com.projectaurora.backend.dto.auth.RegisterRequest;
import com.projectaurora.backend.entity.Role;
import com.projectaurora.backend.entity.User;
import com.projectaurora.backend.entity.UserRole;
import com.projectaurora.backend.entity.UserRoleId;
import com.projectaurora.backend.enums.RoleType;
import com.projectaurora.backend.exception.EmailAlreadyExistsException;
import com.projectaurora.backend.exception.InvalidCredentialsException;
import com.projectaurora.backend.exception.ResourceNotFoundException;
import com.projectaurora.backend.mapper.UserMapper;
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

        // Check if email already exists
        if (userRepository.existsByEmail(request.getEmail())) {
            throw new EmailAlreadyExistsException(
                    "Email already registered: " + request.getEmail());
        }

        // Create user
        User user = User.builder()
                .firstName(request.getFirstName())
                .lastName(request.getLastName())
                .email(request.getEmail())
                .passwordHash(passwordEncoder.encode(request.getPassword()))
                .active(true)
                .emailVerified(false)
                .build();

        // Save user
        user = userRepository.save(user);

        // Fetch default STUDENT role
        Role studentRole = roleRepository.findByRoleName(RoleType.STUDENT)
                .orElseThrow(() ->
                        new ResourceNotFoundException(
                                "Default role STUDENT not found"));

        // Assign role
        UserRole userRole = UserRole.builder()
                .id(new UserRoleId(user.getId(), studentRole.getId()))
                .user(user)
                .role(studentRole)
                .build();

        userRoleRepository.save(userRole);

        // Generate JWT
        String jwtToken = jwtService.generateToken(user.getEmail());

        // Return response
        return AuthResponse.builder()
                .accessToken(jwtToken)
                .tokenType("Bearer")
                .user(UserMapper.toResponse(user))
                .build();
    }

    @Override
    public AuthResponse login(LoginRequest request) {

        authenticationManager.authenticate(
                new UsernamePasswordAuthenticationToken(
                        request.getEmail(),
                        request.getPassword()));

        User user = userRepository.findByEmail(request.getEmail())
                .orElseThrow(() ->
                        new InvalidCredentialsException(
                                "Invalid email or password"));

        String jwtToken = jwtService.generateToken(user.getEmail());

        return AuthResponse.builder()
                .accessToken(jwtToken)
                .tokenType("Bearer")
                .user(UserMapper.toResponse(user))
                .build();
    }
}