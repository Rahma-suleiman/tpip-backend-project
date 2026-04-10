package com.znz.tpip_backend.model;

import jakarta.persistence.*;
import lombok.*;
import java.time.LocalDate;

import com.znz.tpip_backend.enums.ApplicationStatus;
import com.znz.tpip_backend.enums.District;
import com.znz.tpip_backend.enums.EducationLevel;
import com.znz.tpip_backend.enums.Gender;
import com.znz.tpip_backend.enums.Region;
import com.znz.tpip_backend.enums.SchoolType;

@Data
@Entity
@Table(name = "applications")
public class Application extends AuditModel<String> {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Enumerated(EnumType.STRING)
    private ApplicationStatus status; 
    
    // Personal Information
    private String firstName;
    private String lastName;

    @Enumerated(EnumType.STRING)
    private Gender gender;

    private LocalDate dateOfBirth;
    private String phoneNumber;
    private String email;
    private String address;

    // Academic Information
    @Enumerated(EnumType.STRING)
    private EducationLevel educationLevel; 
    
    private String courseStudied;
    private String institutionName;
    private int graduationYear;
    private String qualificationFile; // path to uploaded certificate
    
    // Internship Preferences
    @Enumerated(EnumType.STRING)
    private Region preferredRegion;

    @Enumerated(EnumType.STRING)
    private District preferredDistrict;

    @Enumerated(EnumType.STRING)
    private SchoolType preferredSchoolType; 

    // Application Details
    // private String motivationStatement; // why they want internship
    private LocalDate applicationDate;

    // Documents
    private String cvFile;
    private String transcriptFile;

  
    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "intern_id", nullable = false)
    private Intern intern;

    // // FK
    // @ManyToOne(fetch = FetchType.LAZY)
    // @JoinColumn(name = "departmentId", nullable = false)
    // private Department department;

    // // REVERSE R/SHIP MAPPING 
    // @OneToMany(mappedBy = "employee", cascade = CascadeType.ALL, fetch = FetchType.LAZY)
    // private List<LeaveRequest> leaveRequests = new ArrayList<>();
}