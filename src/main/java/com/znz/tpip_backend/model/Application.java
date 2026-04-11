package com.znz.tpip_backend.model;

import jakarta.persistence.*;
import lombok.*;
import java.time.LocalDate;

import com.znz.tpip_backend.enums.*;

@Data
@Entity
@Table(name = "applications")
public class Application extends AuditModel<String> {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    // 📊 Status
    @Enumerated(EnumType.STRING)
    private ApplicationStatus status = ApplicationStatus.PENDING;

    // 🔗 Applicant WHO APPLIED -user can apply multiple times
    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "user_id", nullable = false)
    private User user;

    // 👤 Personal Info
    private String firstName;
    private String lastName;

    @Enumerated(EnumType.STRING)
    private Gender gender;

    private LocalDate dateOfBirth;
    private String phoneNumber;

    @Column(nullable = false, unique = true)
    private String email;
    private String address;

    // 🎓 Academic Info
    @Enumerated(EnumType.STRING)
    private EducationLevel educationLevel;

    private String courseStudied;
    private String institutionName;
    private int graduationYear;
    private String qualificationFile;

    // 📍 Preferences
    @Enumerated(EnumType.STRING)
    private Region preferredRegion;

    @Enumerated(EnumType.STRING)
    private District preferredDistrict;

    @Enumerated(EnumType.STRING)
    private SchoolType preferredSchoolType;

    private LocalDate applicationDate;

    // 📂 Documents
    private String cvFile;
    private String transcriptFile;

    // 🔍 Admin review
    private String reviewedBy;
    private LocalDate reviewDate;
}