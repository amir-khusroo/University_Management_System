package com.UniversityManagementSystem.entity;

import jakarta.persistence.*;

import java.util.List;
import java.util.UUID;

@Entity
public class Student {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;

    private String name;

    private String email;

    private String phone;

    private String dob;

    private String address;

    private String rollno;

    @ManyToOne
    private Department department;

    @ManyToOne
    private Course course;

    @ManyToMany
    private List<Semester> semesters;

}
