package com.teamportal.controller;

import com.teamportal.dto.ActivityDTO;
import com.teamportal.service.ActivityService;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping("/api/activities")
public class ActivityController {
    private final ActivityService activityService;

    public ActivityController(ActivityService activityService) {
        this.activityService = activityService;
    }

    @GetMapping("/feed")
    public List<ActivityDTO> getFeedActivities() {
        return activityService.getFeedActivities();
    }
}
