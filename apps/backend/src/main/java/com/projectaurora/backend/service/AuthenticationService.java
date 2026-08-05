package com.projectaurora.backend.service;

import com.projectaurora.backend.dto.auth.AuthResponse;
import com.projectaurora.backend.dto.auth.LoginRequest;
import com.projectaurora.backend.dto.auth.RegisterRequest;

public interface AuthenticationService {

    /**
     * Registers a new user.
     *
     * @param request Registration request
     * @return Authentication response containing user details and token
     */
    AuthResponse register(RegisterRequest request);

    /**
     * Authenticates an existing user.
     *
     * @param request Login request
     * @return Authentication response containing user details and token
     */
    AuthResponse login(LoginRequest request);

}