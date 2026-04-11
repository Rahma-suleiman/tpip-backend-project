package com.znz.tpip_backend.dto;

import java.time.LocalDate;

import com.fasterxml.jackson.annotation.JsonProperty;
import com.znz.tpip_backend.enums.PlacementStatus;
import com.znz.tpip_backend.model.Application;
import com.znz.tpip_backend.model.Intern;
import com.znz.tpip_backend.model.Mentor;
import com.znz.tpip_backend.model.School;

import jakarta.persistence.EnumType;
import jakarta.persistence.Enumerated;
import jakarta.persistence.FetchType;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.OneToOne;
import lombok.Data;

@Data
public class PlacementDto {

    @JsonProperty(access = JsonProperty.Access.READ_ONLY)
    private Long id;

    // 📅 Internship duration
    private LocalDate startDate;
    private LocalDate endDate;

    // 📊 Placement status
    @Enumerated(EnumType.STRING)
    private PlacementStatus status;

    private String remarks;

    // fk
    private Long school;
    
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