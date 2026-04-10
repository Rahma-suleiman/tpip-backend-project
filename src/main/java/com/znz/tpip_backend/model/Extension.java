package com.znz.tpip_backend.model;

import java.time.LocalDate;

import com.znz.tpip_backend.enums.ExtensionStatus;

import jakarta.persistence.*;
import lombok.Data;

@Entity
@Data
@Table(name = "extension")
public class Extension {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private LocalDate startDate;
    private LocalDate endDate;
    private String reason;

    @Enumerated(EnumType.STRING)
    private ExtensionStatus status;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "intern_id",nullable = false)
    private Intern intern;

    @OneToOne
    @JoinColumn(name = "evaluation_id", nullable = false)
    private Evaluation evaluation;
}