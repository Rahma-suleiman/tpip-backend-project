package com.znz.tpip_backend.dto;

import java.time.LocalDate;

import com.fasterxml.jackson.annotation.JsonProperty;
import com.znz.tpip_backend.enums.EvaluationStatus;
import com.znz.tpip_backend.enums.EvaluationType;

import lombok.Data;

@Data
public class EvaluationDto {

    @JsonProperty(access = JsonProperty.Access.READ_ONLY)
    private Long id;

    private double score;
    
    @JsonProperty(access = JsonProperty.Access.READ_ONLY)
    private EvaluationStatus status;

    private LocalDate evaluationDate;

    private EvaluationType evaluationType;

    private String remarks;

    //  SUMMARY DATA
    private Double averageRating;
    private Integer totalSessions;
    private Integer totalHours;

    // fk
    private Long internId;
    private Long mentorId;
    private Long placementId;


    // Reverse
    @JsonProperty(access = JsonProperty.Access.READ_ONLY)
    private Long extensionId;
}
