package com.teamportal.controller;

import com.teamportal.dto.TeamStatsDTO;
import com.teamportal.service.TeamService;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/api/teams")
public class TeamController {
    private final TeamService teamService;

    public TeamController(TeamService teamService) {
        this.teamService = teamService;
    }

    @GetMapping("/{team}/stats")
    public TeamStatsDTO getTeamStats(@PathVariable String team) {
        return teamService.getTeamStats(team);
    }
}
