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

    @Enumerated(EnumType.STRING)
    private EvaluationType evaluationType;

 
    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "intern_id", nullable = false)
    private Intern intern;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "mentor_id", nullable = false)
    private Mentor mentor;
    
    @OneToOne(mappedBy = "evaluation", fetch = FetchType.LAZY)
    private Extension extension;
}