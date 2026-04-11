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

    // 🎓 Academic info (kept here for long-term use)
    @Enumerated(EnumType.STRING)
    private EducationLevel educationLevel;

    private String specialization;
    private int graduationYear;

    // 📊 Status
    @Enumerated(EnumType.STRING)
    private InternStatus status;

    private LocalDate startDate;
    private LocalDate endDate;

    // 🔗 Evaluations
    @OneToMany(mappedBy = "intern", cascade = CascadeType.ALL)
    private List<Evaluation> evaluations;

    // 🔗 Extensions
    @OneToMany(mappedBy = "intern", cascade = CascadeType.ALL)
    private List<Extension> extensions;

    // 🔗 Certificate (1 intern → 1 certificate)
    @OneToOne(mappedBy = "intern", cascade = CascadeType.ALL)
    private Certificate certificate;

    // 🔗 Placement (1 intern → 1 placement)
    @OneToOne(mappedBy = "intern", cascade = CascadeType.ALL)
    private Placement placement;

    // 🔗 Activity logs
    @OneToMany(mappedBy = "intern", cascade = CascadeType.ALL)
    private List<InternActivityLog> activityLogs;
}