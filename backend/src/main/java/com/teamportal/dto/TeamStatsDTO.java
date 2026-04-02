package com.teamportal.dto;

public record TeamStatsDTO(
    Integer members,
    Integer activeProjects,
    Integer completedThisMonth,
    Integer efficiency
) {}
