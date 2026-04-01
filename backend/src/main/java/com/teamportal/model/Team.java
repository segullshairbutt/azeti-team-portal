package com.teamportal.model;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.util.ArrayList;
import java.util.List;

@Entity
@Table(name = "teams")
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
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
}
