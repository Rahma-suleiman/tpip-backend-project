package com.znz.tpip_backend.model;

import java.time.LocalDate;

import com.znz.tpip_backend.enums.EvaluationStatus;

import jakarta.persistence.*;
import lombok.Data;

@Data
@Entity
@Table(name="evaluations")
public class Evaluation {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private double score;

    @Enumerated(EnumType.STRING)
    private EvaluationStatus status;

    private String remarks;

    // Extension fields
    private Boolean extensionGranted;
    private LocalDate extensionStartDate;
    private LocalDate extensionEndDate;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "intern_id", nullable = false)
    private Intern intern;

    // Optional: Link Evaluation to Extension (if extension comes after evaluation)
    @OneToOne(mappedBy = "evaluation", cascade = CascadeType.ALL)
    private Extension extension;
}