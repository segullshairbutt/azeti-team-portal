package com.teamportal.controller

import com.teamportal.dto.UserDetailDTO
import com.teamportal.service.ActivityDTO
import com.teamportal.service.UserService
import org.springframework.web.bind.annotation.GetMapping
import org.springframework.web.bind.annotation.PathVariable
import org.springframework.web.bind.annotation.RequestMapping
import org.springframework.web.bind.annotation.RestController

@RestController
@RequestMapping("/api/users")
class UserController(
    private val userService: UserService
) {
    @GetMapping("/{id}")
    fun getUser(@PathVariable id: Long): UserDetailDTO {
        return userService.getUserById(id)
    }

    @GetMapping("/{id}/activities")
    fun getUserActivities(@PathVariable id: Long): List<ActivityDTO> {
        return userService.getUserActivities(id)
    }
}
