package com.znz.tpip_backend.model;

import jakarta.persistence.*;
import lombok.Data;
import java.util.List;

import com.znz.tpip_backend.enums.EducationLevel;
import com.znz.tpip_backend.enums.InternStatus;

@Data
@Entity
@Table(name = "interns")
public class Intern extends User {

    @Enumerated(EnumType.STRING)
    private EducationLevel educationLevel; 

    private String specialization; // e.g. Mathematics, English
    private int graduationYear;

    private InternStatus status; // ACTIVE, COMPLETED, EXTENDED

    // are are using the fk or inheritance b2n user and inter/ user and mentor 
    // @OneToOne(fetch = FetchType.LAZY)
    // @JoinColumn(name = "user_id", nullable = false)
    // private User user;   

    // reverse r/ship
    @OneToMany(mappedBy = "intern", cascade = CascadeType.ALL, fetch = FetchType.LAZY)
    private List<Application> applications;

    @OneToMany(mappedBy = "intern", cascade = CascadeType.ALL, fetch = FetchType.LAZY)
    private List<Evaluation> evaluations;

    @OneToMany(mappedBy = "intern", cascade = CascadeType.ALL, fetch = FetchType.LAZY)
    private List<Extension> extensions;

    @OneToOne(mappedBy = "intern", cascade = CascadeType.ALL, fetch = FetchType.LAZY)
    private Certificate certificate;

    @OneToOne(mappedBy = "intern", cascade = CascadeType.ALL, fetch = FetchType.LAZY)
    private Placement placement;

    @OneToMany(mappedBy = "intern", cascade = CascadeType.ALL, fetch = FetchType.LAZY)
    private List<InternActivityLog> activityLogs;
}