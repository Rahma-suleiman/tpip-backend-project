package com.znz.tpip_backend.dto;

import java.time.LocalDate;

import com.fasterxml.jackson.annotation.JsonProperty;
import com.znz.tpip_backend.enums.PlacementStatus;

import jakarta.persistence.EnumType;
import jakarta.persistence.Enumerated;
import lombok.Data;

@Data
public class PlacementDto {

    @JsonProperty(access = JsonProperty.Access.READ_ONLY)
    private Long id;
    
    private LocalDate startDate;
    
    private LocalDate endDate;
    
    @JsonProperty(access = JsonProperty.Access.READ_ONLY)
    private LocalDate assignedDate;

    @Enumerated(EnumType.STRING)
    private PlacementStatus status;

    private String remarks;

    // fk
    private Long school;
    
    // reverse
    private Long mentorId;

    private Long internId;

    private Long applicationId;
}