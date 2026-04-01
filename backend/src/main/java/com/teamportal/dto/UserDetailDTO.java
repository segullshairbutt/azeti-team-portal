package com.teamportal.dto;

public class UserDetailDTO {
    private Long id;
    private String name;
    private String email;
    private ActivityDTO lastActivity;

    public UserDetailDTO() {
    }

    public UserDetailDTO(Long id, String name, String email) {
        this.id = id;
        this.name = name;
        this.email = email;
    }

    public UserDetailDTO(Long id, String name, String email, ActivityDTO lastActivity) {
        this.id = id;
        this.name = name;
        this.email = email;
        this.lastActivity = lastActivity;
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

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public ActivityDTO getLastActivity() {
        return lastActivity;
    }

    public void setLastActivity(ActivityDTO lastActivity) {
        this.lastActivity = lastActivity;
    }
}
