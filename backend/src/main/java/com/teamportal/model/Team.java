package com.teamportal.model;

import jakarta.persistence.*;
import java.util.ArrayList;
import java.util.List;

@Entity
@Table(name = "teams")
public class Team {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(nullable = false)
    private String name;

    @Column(nullable = false)
    private Integer members;

    @Column(name = "active_projects", nullable = false)
    private Integer activeProjects;

    @Column(name = "completed_this_month", nullable = false)
    private Integer completedThisMonth;

    @Column(nullable = false)
    private Integer efficiency;

    @OneToMany(mappedBy = "team", fetch = FetchType.LAZY)
    private List<User> users = new ArrayList<>();

    public Team() {
    }

    public Team(Long id, String name, Integer members, Integer activeProjects, Integer completedThisMonth, Integer efficiency, List<User> users) {
        this.id = id;
        this.name = name;
        this.members = members;
        this.activeProjects = activeProjects;
        this.completedThisMonth = completedThisMonth;
        this.efficiency = efficiency;
        this.users = users != null ? users : new ArrayList<>();
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
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

    public List<User> getUsers() {
        return users;
    }

    public void setUsers(List<User> users) {
        this.users = users != null ? users : new ArrayList<>();
    }
}
