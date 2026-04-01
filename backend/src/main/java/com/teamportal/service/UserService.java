package com.teamportal.service;

import com.teamportal.dto.ActivityDTO;
import com.teamportal.dto.UserDetailDTO;
import com.teamportal.repository.ActivityRepository;
import com.teamportal.repository.UserRepository;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Service;
import org.springframework.web.server.ResponseStatusException;

import java.time.format.DateTimeFormatter;
import java.util.List;
import java.util.stream.Collectors;

@Service
public class UserService {
    private final ActivityRepository activityRepository;
    private final UserRepository userRepository;
    private final DateTimeFormatter formatter;

    public UserService(ActivityRepository activityRepository, UserRepository userRepository) {
        this.activityRepository = activityRepository;
        this.userRepository = userRepository;
        this.formatter = DateTimeFormatter.ofPattern("M/d/yyyy, h:mm:ss a");
    }

    public List<ActivityDTO> getUserActivities(Long userId) {
        return activityRepository.findByUserId(userId).stream()
                .map(activity -> new ActivityDTO(
                        activity.getId(),
                        activity.getAction(),
                        activity.getTimestamp().format(formatter)
                ))
                .collect(Collectors.toList());
    }

    public UserDetailDTO getUserById(Long userId) {
        var user = userRepository.findById(userId)
                .orElseThrow(() -> new ResponseStatusException(HttpStatus.NOT_FOUND, "User not found: " + userId));

        var lastActivity = activityRepository.findFirstByUserIdOrderByTimestampDesc(userId);
        ActivityDTO lastActivityDTO = null;

        if (lastActivity.isPresent()) {
            var activity = lastActivity.get();
            lastActivityDTO = new ActivityDTO(
                    activity.getId(),
                    activity.getAction(),
                    activity.getTimestamp().format(formatter),
                    activity.getUser() != null ? activity.getUser().getName() : null
            );
        }

        return new UserDetailDTO(
                user.getId(),
                user.getName(),
                user.getEmail(),
                lastActivityDTO
        );
    }
}
