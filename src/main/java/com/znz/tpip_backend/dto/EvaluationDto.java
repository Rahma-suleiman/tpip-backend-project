package com.znz.tpip_backend.dto;

import com.fasterxml.jackson.annotation.JsonProperty;
import com.znz.tpip_backend.enums.EvaluationStatus;

import lombok.Data;

@Data
public class EvaluationDto {

    @JsonProperty(access = JsonProperty.Access.READ_ONLY)
    private Long id;
    
    private double score;
    
    private EvaluationStatus status;
    
    private String remarks;
    
    // Forward r/ship
    private Long internId;
    
    // Reverse 
    @JsonProperty(access = JsonProperty.Access.READ_ONLY)
    private Long extensionId;
}
