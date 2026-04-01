package com.teamportal.controller;

import com.teamportal.dto.ActivityDTO;
import com.teamportal.dto.UserDetailDTO;
import com.teamportal.service.UserService;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping("/api/users")
public class UserController {
    private final UserService userService;

    public UserController(UserService userService) {
        this.userService = userService;
    }

    @GetMapping("/{id}")
    public UserDetailDTO getUser(@PathVariable Long id) {
        return userService.getUserById(id);
    }

    @GetMapping("/{id}/activities")
    public List<ActivityDTO> getUserActivities(@PathVariable Long id) {
        return userService.getUserActivities(id);
    }
}
