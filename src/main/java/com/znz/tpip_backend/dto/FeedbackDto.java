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
    private Long mentor;
    
    // private Long intern; //cant access feedback
}
