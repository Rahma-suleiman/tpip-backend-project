package com.znz.tpip_backend.model;

import jakarta.persistence.*;
import lombok.Data;
import java.time.LocalDate;
import java.util.List;

import com.znz.tpip_backend.enums.*;

@Data
@Entity
@Table(name = "interns")
public class Intern extends User {

    @Enumerated(EnumType.STRING)
    private EducationLevel educationLevel;

    private String specialization;
    
    private int graduationYear;

    @Enumerated(EnumType.STRING)
    private InternStatus status;

    private LocalDate startDate;

    private LocalDate endDate;

    // reverse r/ship
    @OneToMany(mappedBy = "intern", cascade = CascadeType.ALL)
    private List<Evaluation> evaluations;

    @OneToMany(mappedBy = "intern", cascade = CascadeType.ALL)
    private List<Extension> extensions;

    @OneToOne(mappedBy = "intern", cascade = CascadeType.ALL)
    private Certificate certificate;

    @OneToOne(mappedBy = "intern", cascade = CascadeType.ALL)
    private Placement placement;

    @OneToMany(mappedBy = "intern", cascade = CascadeType.ALL)
    private List<InternActivityLog> activityLogs;
}