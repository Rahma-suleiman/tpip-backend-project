package com.znz.tpip_backend.model;

import jakarta.persistence.*;
import lombok.*;

@Entity
@Getter
@Setter
@Table(name = "mentor")
public class Placement extends AuditModel<String> {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "school_id", nullable = false)
    private School school;  

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "mentor_id", nullable = false)
    private Mentor mentor;

    // @ManyToOne(fetch = FetchType.LAZY) //OR
    @OneToOne(fetch = FetchType.LAZY) 
    @JoinColumn(name = "intern_id", nullable = false)
    private Intern intern;

}
