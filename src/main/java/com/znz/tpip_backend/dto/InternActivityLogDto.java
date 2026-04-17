package com.znz.tpip_backend.dto;

import java.time.LocalDate;

import com.fasterxml.jackson.annotation.JsonProperty;
import com.znz.tpip_backend.enums.ActivityLogStatus;

import lombok.Data;

@Data
public class InternActivityLogDto {

    @JsonProperty(access = JsonProperty.Access.READ_ONLY)
    private Long id;

    private LocalDate date;

    private LocalDate reviewDate;

    private String subject;

    private String topicTaught;

    private String classLevel;

    private String activitiesDone;

    private String challenges;

    private double hoursSpent;

    private String mentorComment;

    private ActivityLogStatus status;

    // fk
    private Long intern;

    private Long mentor;
}