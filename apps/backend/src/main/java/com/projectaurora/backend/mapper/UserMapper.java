package com.projectaurora.backend.mapper;

import com.projectaurora.backend.dto.auth.RegisterRequest;
import com.projectaurora.backend.dto.auth.UserResponse;
import com.projectaurora.backend.entity.User;

public final class UserMapper {

    private UserMapper() {
    }

    /**
     * Converts RegisterRequest DTO to User Entity.
     */
    public static User toEntity(RegisterRequest request) {

        return User.builder()
                .firstName(request.getFirstName())
                .lastName(request.getLastName())
                .email(request.getEmail())
                .build();
    }

    /**
     * Converts User Entity to UserResponse DTO.
     */
    public static UserResponse toResponse(User user) {

        return UserResponse.builder()
                .id(user.getId())
                .firstName(user.getFirstName())
                .lastName(user.getLastName())
                .email(user.getEmail())
                .profileImageUrl(user.getProfileImageUrl())
                .bio(user.getBio())
                .active(user.getActive())
                .emailVerified(user.getEmailVerified())
                .build();
    }

    /**
     * Updates an existing User entity with values from RegisterRequest.
     */
    public static void updateEntity(User user, RegisterRequest request) {

        user.setFirstName(request.getFirstName());
        user.setLastName(request.getLastName());
        user.setEmail(request.getEmail());

    }
}