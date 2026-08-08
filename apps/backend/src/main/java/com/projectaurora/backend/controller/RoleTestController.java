package com.projectaurora.backend.controller;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/api/test")
public class RoleTestController {

    @GetMapping("/student")
    public String studentAccess() {
        return "STUDENT access granted.";
    }

    @GetMapping("/instructor")
    public String instructorAccess() {
        return "INSTRUCTOR access granted.";
    }

    @GetMapping("/admin")
    public String adminAccess() {
        return "ADMIN access granted.";
    }
}