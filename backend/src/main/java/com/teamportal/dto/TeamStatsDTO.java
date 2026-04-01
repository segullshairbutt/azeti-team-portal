package com.teamportal.dto;

public class TeamStatsDTO {
    private Integer members;
    private Integer activeProjects;
    private Integer completedThisMonth;
    private Integer efficiency;

    public TeamStatsDTO() {
    }

    public TeamStatsDTO(Integer members, Integer activeProjects, Integer completedThisMonth, Integer efficiency) {
        this.members = members;
        this.activeProjects = activeProjects;
        this.completedThisMonth = completedThisMonth;
        this.efficiency = efficiency;
    }

    public Integer getMembers() {
        return members;
    }

    public void setMembers(Integer members) {
        this.members = members;
    }

    public Integer getActiveProjects() {
        return activeProjects;
    }

    public void setActiveProjects(Integer activeProjects) {
        this.activeProjects = activeProjects;
    }

    public Integer getCompletedThisMonth() {
        return completedThisMonth;
    }

    public void setCompletedThisMonth(Integer completedThisMonth) {
        this.completedThisMonth = completedThisMonth;
    }

    public Integer getEfficiency() {
        return efficiency;
    }

    public void setEfficiency(Integer efficiency) {
        this.efficiency = efficiency;
    }
}
