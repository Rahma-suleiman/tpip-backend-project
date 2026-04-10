package com.znz.tpip_backend.dto;

import java.time.LocalDate;

import lombok.Data;

@Data
public class InternActivityLogDto {
    private int logId;
    private LocalDate date;
    private String topicTaught;
    private String activitiesDone;
    private String challenges;
    private double hoursSpent;
    private String mentorComment;
    private String status;

    private int intern;
}
