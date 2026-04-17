package com.znz.tpip_backend.dto;

import java.time.LocalDate;

import com.fasterxml.jackson.annotation.JsonProperty;

import lombok.Data;

@Data
public class FeedbackDto {

    @JsonProperty(access = JsonProperty.Access.READ_ONLY)
    private Long id;
    
    private int rating;
    
    private String comment;
    
    private LocalDate date;
    
    // forward r/ship
    private Long mentorId;
    @JsonProperty(access = JsonProperty.Access.READ_ONLY)
    private String mentorName;
    
    private Long internId; 
    
    @JsonProperty(access = JsonProperty.Access.READ_ONLY)
    private String internName;

    private Long placementId;
    
}
