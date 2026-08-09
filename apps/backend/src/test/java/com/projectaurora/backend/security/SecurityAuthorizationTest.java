package com.projectaurora.backend.security;

import static org.springframework.security.test.web.servlet.request.SecurityMockMvcRequestPostProcessors.user;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.webmvc.test.autoconfigure.AutoConfigureMockMvc;
import org.springframework.test.web.servlet.MockMvc;

@SpringBootTest
@AutoConfigureMockMvc
class SecurityAuthorizationTest {

    @Autowired
    private MockMvc mockMvc;

    @Test
    void studentCanAccessStudentEndpoint() throws Exception {

        mockMvc.perform(
                get("/api/test/student")
                        .with(user("student")
                                .roles("STUDENT")))
                .andExpect(status().isOk());
    }

    @Test
    void studentCannotAccessInstructorEndpoint() throws Exception {

        mockMvc.perform(
                get("/api/test/instructor")
                        .with(user("student")
                                .roles("STUDENT")))
                .andExpect(status().isForbidden());
    }

    @Test
    void studentCannotAccessAdminEndpoint() throws Exception {

        mockMvc.perform(
                get("/api/test/admin")
                        .with(user("student")
                                .roles("STUDENT")))
                .andExpect(status().isForbidden());
    }

    @Test
    void instructorCanAccessInstructorEndpoint() throws Exception {

        mockMvc.perform(
                get("/api/test/instructor")
                        .with(user("instructor")
                                .roles("INSTRUCTOR")))
                .andExpect(status().isOk());
    }

    @Test
    void instructorCannotAccessAdminEndpoint() throws Exception {

        mockMvc.perform(
                get("/api/test/admin")
                        .with(user("instructor")
                                .roles("INSTRUCTOR")))
                .andExpect(status().isForbidden());
    }

    @Test
    void adminCanAccessAdminEndpoint() throws Exception {

        mockMvc.perform(
                get("/api/test/admin")
                        .with(user("admin")
                                .roles("ADMIN")))
                .andExpect(status().isOk());
    }
}