package com.znz.tpip_backend.dto;

import java.time.LocalDate;
import java.util.List;

import com.fasterxml.jackson.annotation.JsonProperty;
import com.znz.tpip_backend.enums.EducationLevel;
import com.znz.tpip_backend.enums.InternStatus;

import lombok.Data;

@Data
public class InternDto {

    @JsonProperty(access = JsonProperty.Access.READ_ONLY)
    private Long id;

    private EducationLevel educationLevel;

    private String specialization;

    private int graduationYear;

    private InternStatus status;

    private LocalDate startDate;

    private LocalDate endDate;

    // fk
    // private Long userId;  It creates redundancy. BCZ: Application already has User . So technically: Intern → Application → User (You could derive user from application.)
    private Long applicationId;

    // reverse r/ships
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

     // ===== Names (for frontend display) =====
    // private String userName;
    // private String userEmail;
    private String applicantName;
    private String applicantEmail;
}
