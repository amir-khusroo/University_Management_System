package com.UniversityManagementSystem.entity;

import jakarta.persistence.*;

import java.util.List;
import java.util.UUID;

@Entity
public class Faculty {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;

    private String name;

    private String email;

    private String phone;

    private String profileSummary;

    @ManyToOne
    private Department department;

    @OneToMany(mappedBy = "faculty" , cascade = CascadeType.ALL)
    private Subject subject;

}
