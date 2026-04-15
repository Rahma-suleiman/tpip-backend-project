package com.znz.tpip_backend.dto;

import java.time.LocalDate;

import com.fasterxml.jackson.annotation.JsonProperty;
import com.znz.tpip_backend.enums.PlacementStatus;
import lombok.Data;

@Data
public class PlacementDto {

    @JsonProperty(access = JsonProperty.Access.READ_ONLY)
    private Long id;
    
    private LocalDate startDate;
    
    private LocalDate endDate;
    
    @JsonProperty(access = JsonProperty.Access.READ_ONLY)
    private LocalDate assignedDate;
    
    // @JsonProperty(access = JsonProperty.Access.READ_ONLY)
    private PlacementStatus status;

    private String remarks;

    // fk IDs (for backend operations) =====
    private Long schoolId;

    private Long mentorId;

    private Long internId;

     // ===== Names (for frontend display) =====
    private String schoolName;
    private String mentorName;
    private String internName;

    // private Long applicationId;
}