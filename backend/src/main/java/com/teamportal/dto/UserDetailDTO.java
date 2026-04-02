package com.teamportal.dto;

public record UserDetailDTO(Long id, String name, String email, ActivityDTO lastActivity) {

    public UserDetailDTO(Long id, String name, String email) {
        this(id, name, email, null);
    }
}
