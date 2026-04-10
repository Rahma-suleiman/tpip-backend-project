package com.znz.tpip_backend.model;

import java.time.LocalDate;
import java.util.ArrayList;

import com.znz.tpip_backend.enums.EvaluationStatus;

import jakarta.persistence.*;
import lombok.Data;

@Data
@Entity
@Table(name="evaluations")
public class Evaluation extends AuditModel<String>{

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private double score;

    @Enumerated(EnumType.STRING)
    private EvaluationStatus status;

    private String remarks;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "intern_id", nullable = false)
    private Intern intern;

    // Optional: Link Evaluation to Extension (if extension comes after evaluation)
    // Reverse R/ship
    @OneToOne(mappedBy = "evaluation", cascade = CascadeType.ALL, fetch = FetchType.LAZY)
    private Extension extension;
}