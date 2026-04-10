package com.znz.tpip_backend.dto;

import com.fasterxml.jackson.annotation.JsonProperty;

import lombok.Data;

@Data
public class PlacementDto {
    
    @JsonProperty(access = JsonProperty.Access.READ_ONLY)
    private Long id;

    // fk
    private Long school;

    private Long mentorId;

    private Long internId;
}