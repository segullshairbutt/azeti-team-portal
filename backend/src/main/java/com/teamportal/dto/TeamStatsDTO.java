package com.teamportal.dto;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class TeamStatsDTO {
    private Integer members;
    private Integer activeProjects;
    private Integer completedThisMonth;
    private Integer efficiency;
}
