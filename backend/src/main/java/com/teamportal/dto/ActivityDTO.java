package com.teamportal.dto;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class ActivityDTO {
    private Long id;
    private String action;
    private String timestamp;
    private String userName;

    public ActivityDTO(Long id, String action, String timestamp) {
        this.id = id;
        this.action = action;
        this.timestamp = timestamp;
    }
}
