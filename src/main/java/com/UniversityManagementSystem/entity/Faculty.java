package com.UniversityManagementSystem.entity;

import jakarta.persistence.*;

import java.util.UUID;

@Entity
public class Faculty {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private UUID id;

    @OneToOne
    private User user;

    @ManyToOne
    private Department department;

    private String title;
    private String phone;
    private String profileSummary;
}
