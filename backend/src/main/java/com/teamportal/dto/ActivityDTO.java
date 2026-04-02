package com.teamportal.dto;

public record ActivityDTO(Long id, String action, String timestamp, String userName) {

    public ActivityDTO(Long id, String action, String timestamp) {
        this(id, action, timestamp, null);
    }
}
