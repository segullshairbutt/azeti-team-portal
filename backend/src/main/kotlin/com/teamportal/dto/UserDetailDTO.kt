package com.teamportal.dto

import com.teamportal.service.ActivityDTO

data class UserDetailDTO(
    val id: Long,
    val name: String,
    val email: String,
    val lastActivity: ActivityDTO? = null
)
