package com.projectaurora.backend.service.impl;

import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.AuthenticationServiceException;
import org.springframework.security.authentication.BadCredentialsException;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

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

    /**
     * Registers a new user and assigns the default STUDENT role.
     */
    @Override
    @Transactional
    public AuthResponse register(RegisterRequest request) {

        // 1. Check if email already exists
        if (userRepository.existsByEmail(request.getEmail())) {
            throw new EmailAlreadyExistsException(
                    "Email already registered: " + request.getEmail());
        }

        // 2. Create user
        User user = User.builder()
                .firstName(request.getFirstName())
                .lastName(request.getLastName())
                .email(request.getEmail())
                .passwordHash(passwordEncoder.encode(request.getPassword()))
                .active(true)
                .emailVerified(false)
                .build();

        // 3. Save user
        user = userRepository.save(user);

        // 4. Fetch default STUDENT role
        Role studentRole = roleRepository.findByRoleName(RoleType.STUDENT)
                .orElseThrow(() ->
                        new ResourceNotFoundException(
                                "Default role STUDENT not found"));

        // 5. Create user-role relationship
        UserRole userRole = UserRole.builder()
                .id(new UserRoleId(
                        user.getId(),
                        studentRole.getId()))
                .user(user)
                .role(studentRole)
                .build();

        // 6. Save user-role relationship
        userRoleRepository.save(userRole);

        // 7. Generate JWT
        String jwtToken = jwtService.generateToken(user.getEmail());

        // 8. Return authentication response
        return AuthResponse.builder()
                .accessToken(jwtToken)
                .tokenType("Bearer")
                .user(UserMapper.toResponse(user))
                .build();
    }

    /**
     * Authenticates an existing user and generates a JWT.
     */
    @Override
    public AuthResponse login(LoginRequest request) {

        try {

            // 1. Authenticate email and password
            authenticationManager.authenticate(
                    new UsernamePasswordAuthenticationToken(
                            request.getEmail(),
                            request.getPassword()));

        } catch (BadCredentialsException ex) {

            throw new InvalidCredentialsException(
                    "Invalid email or password");

        } catch (AuthenticationServiceException ex) {

            throw new InvalidCredentialsException(
                    "Unable to authenticate user");

        }

        // 2. Fetch authenticated user
        User user = userRepository.findByEmail(request.getEmail())
                .orElseThrow(() ->
                        new InvalidCredentialsException(
                                "Invalid email or password"));

        // 3. Check whether account is active
        if (!Boolean.TRUE.equals(user.getActive())) {
            throw new InvalidCredentialsException(
                    "User account is inactive");
        }

        // 4. Generate JWT
        String jwtToken = jwtService.generateToken(user.getEmail());

        // 5. Return authentication response
        return AuthResponse.builder()
                .accessToken(jwtToken)
                .tokenType("Bearer")
                .user(UserMapper.toResponse(user))
                .build();
    }
}