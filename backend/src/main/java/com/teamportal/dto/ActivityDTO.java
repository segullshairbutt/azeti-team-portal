package com.teamportal.dto;

public class ActivityDTO {
    private Long id;
    private String action;
    private String timestamp;
    private String userName;

    public ActivityDTO() {
    }

    public ActivityDTO(Long id, String action, String timestamp) {
        this.id = id;
        this.action = action;
        this.timestamp = timestamp;
    }

    public ActivityDTO(Long id, String action, String timestamp, String userName) {
        this.id = id;
        this.action = action;
        this.timestamp = timestamp;
        this.userName = userName;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getAction() {
        return action;
    }

    public void setAction(String action) {
        this.action = action;
    }

    public String getTimestamp() {
        return timestamp;
    }

    public void setTimestamp(String timestamp) {
        this.timestamp = timestamp;
    }

    public String getUserName() {
        return userName;
    }

    public void setUserName(String userName) {
        this.userName = userName;
    }
}
