package com.znz.tpip_backend.dto;

import java.util.List;

import com.fasterxml.jackson.annotation.JsonProperty;
import com.znz.tpip_backend.enums.EducationLevel;
import com.znz.tpip_backend.enums.InternStatus;
import lombok.Data;

@Data
public class InternDto {

    @JsonProperty(access = JsonProperty.Access.READ_ONLY)
    private Long id;

    // private int experienceLevel;

    private EducationLevel educationLevel; 

    private String specialization; 
    private int graduationYear;

    private InternStatus status; 

    // private Long userId; 

    // reverse r/ships
    @JsonProperty(access = JsonProperty.Access.READ_ONLY)
    private List<Long> applicationIds;

    @JsonProperty(access = JsonProperty.Access.READ_ONLY)
    private List<Long> evaluationIds;

    @JsonProperty(access = JsonProperty.Access.READ_ONLY)
    private List<Long> extensionIds;

    @JsonProperty(access = JsonProperty.Access.READ_ONLY)
    private Long certificateId;

    @JsonProperty(access = JsonProperty.Access.READ_ONLY)
    private Long placementId;

    @JsonProperty(access = JsonProperty.Access.READ_ONLY)
    private List<Long> activityLogIds;

}
