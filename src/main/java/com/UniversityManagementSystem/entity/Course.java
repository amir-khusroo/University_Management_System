package com.UniversityManagementSystem.entity;

import jakarta.persistence.*;

import java.util.UUID;

@Entity
public class Course {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private UUID id;

    private String code;

    private String title;

    private String description;

    @ManyToOne
    private Department department;

//    @ManyToOne
//    private Faculty faculty;


}
