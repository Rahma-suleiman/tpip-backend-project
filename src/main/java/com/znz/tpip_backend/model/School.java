package com.znz.tpip_backend.model;

import java.util.ArrayList;
import java.util.List;

import com.znz.tpip_backend.enums.Region;
import com.znz.tpip_backend.enums.District;
import com.znz.tpip_backend.enums.SchoolType;

import jakarta.persistence.*;
import lombok.*;

@Entity
@Getter
@Setter
@Table(name = "schools")
public class School extends AuditModel<String> {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private String name;

    private String location; // physical address

    // 🌍 Location hierarchy
    @Enumerated(EnumType.STRING)
    private Region region;

    @Enumerated(EnumType.STRING)
    private District district;

    // 🏫 School type
    @Enumerated(EnumType.STRING)
    private SchoolType schoolType;

 
    private int capacity; // max interns allowed

    private int currentInternCount;
    private String phoneNumber;
    private String email;

    private String headTeacherName;

 
    @OneToMany(mappedBy = "school", cascade = CascadeType.ALL, fetch = FetchType.LAZY)
    private List<Placement> placements = new ArrayList<>();

    @OneToMany(mappedBy = "school", cascade = CascadeType.ALL, fetch = FetchType.LAZY)
    private List<Mentor> mentors = new ArrayList<>();
}