package com.znz.tpip_backend.dto;

import java.time.LocalDate;

import com.fasterxml.jackson.annotation.JsonProperty;
import com.znz.tpip_backend.enums.PlacementStatus;
import com.znz.tpip_backend.model.Application;
import com.znz.tpip_backend.model.Intern;
import com.znz.tpip_backend.model.Mentor;

import jakarta.persistence.EnumType;
import jakarta.persistence.Enumerated;
import jakarta.persistence.FetchType;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.OneToOne;
import lombok.Data;

@Data
public class PlacementDto {

    @JsonProperty(access = JsonProperty.Access.READ_ONLY)
    private Long id;

    private LocalDate startDate;

    private LocalDate endDate;

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