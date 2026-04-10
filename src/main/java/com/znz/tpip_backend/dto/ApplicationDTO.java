package com.znz.tpip_backend.dto;

import lombok.Data;
import java.time.LocalDate;

import com.fasterxml.jackson.annotation.JsonProperty;
import com.znz.tpip_backend.enums.ApplicationStatus;
import com.znz.tpip_backend.enums.District;
import com.znz.tpip_backend.enums.EducationLevel;
import com.znz.tpip_backend.enums.Gender;
import com.znz.tpip_backend.enums.Region;
import com.znz.tpip_backend.enums.SchoolType;


@Data
public class ApplicationDTO {

    @JsonProperty(access = JsonProperty.Access.READ_ONLY)
    private Long id;

    private ApplicationStatus status; 

    private String firstName;
    private String lastName;

    private Gender gender;

    private LocalDate dateOfBirth;
    private String phoneNumber;
    private String email;
    private String address;

    private EducationLevel educationLevel; 
    
    private String courseStudied;
    private String institutionName;
    private int graduationYear;
    private String qualificationFile; 
    
    private Region preferredRegion;

    private District preferredDistrict;

    private SchoolType preferredSchoolType; 

    private LocalDate applicationDate;

    // Documents
    private String cvFile;
    private String transcriptFile;

    // forward r/ship
    private Long internId;

    // // reverse r/ships
    // @JsonProperty(access = JsonProperty.Access.READ_ONLY)
    // private List<Long> employeeIds;
}