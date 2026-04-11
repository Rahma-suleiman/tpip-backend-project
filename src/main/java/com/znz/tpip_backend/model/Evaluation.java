package com.znz.tpip_backend.model;

import java.time.LocalDate;

import com.znz.tpip_backend.enums.EvaluationStatus;
import com.znz.tpip_backend.enums.EvaluationType;

import jakarta.persistence.*;
import lombok.Data;

@Data
@Entity
@Table(name = "evaluations")
public class Evaluation extends AuditModel<String> {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private double score;

    @Enumerated(EnumType.STRING)
    private EvaluationStatus status;

    private String remarks;

    private LocalDate evaluationDate;

    // Optional: type of evaluation (Midterm, Final)
    @Enumerated(EnumType.STRING)
    private EvaluationType evaluationType;

 
    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "intern_id", nullable = false)
    private Intern intern;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "mentor_id", nullable = false)
    private Mentor mentor;

    // @OneToOne(mappedBy = "evaluation", cascade = CascadeType.ALL, fetch = FetchType.LAZY)
    // private Extension extension;
    
    // OPTIONAL BACK-REFERENCE (NOT REQUIRED FOR LOGIC)
    @OneToOne(mappedBy = "evaluation", fetch = FetchType.LAZY)
    private Extension extension;
}