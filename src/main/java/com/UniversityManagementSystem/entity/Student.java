package com.UniversityManagementSystem.entity;

import jakarta.persistence.*;

import java.util.UUID;

@Entity
public class Student {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private UUID id;

    @OneToOne
    private User user;

    private String rollno;

    @ManyToOne
    private Department department;

    private Integer year;
    private String program;
    private String phone;
    private String address;
}
