package com.teamportal.service;

import com.teamportal.dto.TeamStatsDTO;
import com.teamportal.repository.TeamRepository;
import org.springframework.stereotype.Service;

@Service
public class TeamService {
    private final TeamRepository teamRepository;

    public TeamService(TeamRepository teamRepository) {
        this.teamRepository = teamRepository;
    }

    public TeamStatsDTO getTeamStats(String teamName) {
        var team = teamRepository.findByNameIgnoreCase(teamName)
                .orElseThrow(() -> new RuntimeException("Team not found: " + teamName));

        return new TeamStatsDTO(
                team.getMembers(),
                team.getActiveProjects(),
                team.getCompletedThisMonth(),
                team.getEfficiency()
        );
    }
}
