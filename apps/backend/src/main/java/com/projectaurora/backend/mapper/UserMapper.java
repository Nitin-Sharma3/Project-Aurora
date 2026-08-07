package com.projectaurora.backend.mapper;

import com.projectaurora.backend.dto.auth.UserResponse;
import com.projectaurora.backend.entity.User;

public final class UserMapper {

    private UserMapper() {
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
}