package com.znz.tpip_backend.model;

import java.time.LocalDate;

import jakarta.persistence.*;
import lombok.*;

@Getter
@Setter
@Entity
@Table(name = "interActivityLog")
public class InternActivityLog {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long logId;

    private LocalDate date;

    private String topicTaught;

    private String activitiesDone;

    private String challenges;

    private double hoursSpent;

    private String mentorComment;

    private String status;

    private Intern intern;
}
