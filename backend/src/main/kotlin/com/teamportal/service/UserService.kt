package com.teamportal.service

import com.teamportal.dto.UserDetailDTO
import com.teamportal.repository.ActivityRepository
import com.teamportal.repository.UserRepository
import org.springframework.http.HttpStatus
import org.springframework.stereotype.Service
import org.springframework.web.server.ResponseStatusException
import java.time.format.DateTimeFormatter

@Service
class UserService(
    private val activityRepository: ActivityRepository,
    private val userRepository: UserRepository
) {
    private val formatter = DateTimeFormatter.ofPattern("M/d/yyyy, h:mm:ss a")

    fun getUserActivities(userId: Long): List<ActivityDTO> {
        val activities = activityRepository.findByUserId(userId)

        return activities.map { activity ->
            ActivityDTO(
                id = activity.id,
                action = activity.action,
                timestamp = activity.timestamp.format(formatter)
            )
        }
    }

    fun getUserById(userId: Long): UserDetailDTO {
        val user = userRepository.findById(userId)
            .orElseThrow { ResponseStatusException(HttpStatus.NOT_FOUND, "User not found: $userId") }
        
        val lastActivity = activityRepository.findFirstByUserIdOrderByTimestampDesc(userId)
        val lastActivityDTO = lastActivity?.let {
            ActivityDTO(
                id = it.id,
                action = it.action,
                timestamp = it.timestamp.format(formatter),
                userName = it.user?.name
            )
        }

        return UserDetailDTO(
            id = user.id,
            name = user.name,
            email = user.email,
            lastActivity = lastActivityDTO
        )
    }
}
