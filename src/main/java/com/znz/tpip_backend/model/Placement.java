package com.znz.tpip_backend.model;

import java.time.LocalDate;

import com.znz.tpip_backend.enums.PlacementStatus;

import jakarta.persistence.*;
import lombok.*;

@Entity
@Getter
@Setter
@Table(name = "placements")
public class Placement extends AuditModel<String> {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    // 📅 Internship duration
    private LocalDate startDate;
    private LocalDate endDate;

    // 📊 Placement status
    @Enumerated(EnumType.STRING)
    private PlacementStatus status;

    private String remarks;

    // 🔗 School
    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "school_id", nullable = false)
    private School school;

    // 🔗 Mentor
    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "mentor_id", nullable = false)
    private Mentor mentor;

    // 🔗 Intern (ONE intern → ONE placement)
    @OneToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "intern_id", nullable = false, unique = true)
    private Intern intern;

    // 🔗 Optional: Link to Application (good for tracking origin)
    @OneToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "application_id")
    private Application application;
}