package com.teamportal.service;

import com.teamportal.dto.ActivityDTO;
import com.teamportal.repository.ActivityRepository;
import org.springframework.stereotype.Service;

import java.time.format.DateTimeFormatter;
import java.util.List;
import java.util.stream.Collectors;

@Service
public class ActivityService {
    private final ActivityRepository activityRepository;
    private final DateTimeFormatter formatter;

    public ActivityService(ActivityRepository activityRepository) {
        this.activityRepository = activityRepository;
        this.formatter = DateTimeFormatter.ofPattern("M/d/yyyy, h:mm:ss a");
    }

    public List<ActivityDTO> getFeedActivities() {
        return activityRepository.findAllWithUser().stream()
                .map(activity -> new ActivityDTO(
                        activity.getId(),
                        activity.getAction(),
                        activity.getTimestamp().format(formatter),
                        activity.getUser() != null ? activity.getUser().getName() : null
                ))
                .collect(Collectors.toList());
    }
}
