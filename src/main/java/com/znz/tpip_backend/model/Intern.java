package com.znz.tpip_backend.model;

import jakarta.persistence.*;
import lombok.Data;
import java.util.List;

import com.znz.tpip_backend.enums.EducationLevel;

@Data
@Entity
@Table(name = "interns")
public class Intern extends User {

    // Academic / Professional Info
    @Enumerated(EnumType.STRING)
    private EducationLevel educationLevel; // Diploma / Degree

    private String specialization; // e.g. Mathematics, English
    private int graduationYear;

    // Internship Status
    private String status; // ACTIVE, COMPLETED, EXTENDED

    // Relationships

    @OneToMany(mappedBy = "intern", cascade = CascadeType.ALL, fetch = FetchType.LAZY)
    private List<Application> applications;

    @OneToMany(mappedBy = "intern", cascade = CascadeType.ALL, fetch = FetchType.LAZY)
    private List<Evaluation> evaluations;

    @OneToMany(mappedBy = "intern", cascade = CascadeType.ALL, fetch = FetchType.LAZY)
    private List<Extension> extensions;

    // One Intern → One Certificate
    @OneToOne(mappedBy = "intern", cascade = CascadeType.ALL, fetch = FetchType.LAZY)
    private Certificate certificate;

    // One Intern → One Placement
    @OneToOne(mappedBy = "intern", cascade = CascadeType.ALL, fetch = FetchType.LAZY)
    private Placement placement;

    // One Intern → Many Activity Logs
    @OneToMany(mappedBy = "intern", cascade = CascadeType.ALL, fetch = FetchType.LAZY)
    private List<InternActivityLog> activityLogs;
}