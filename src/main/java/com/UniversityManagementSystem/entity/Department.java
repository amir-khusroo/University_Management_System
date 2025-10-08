package com.UniversityManagementSystem.entity;

import jakarta.persistence.*;

import java.util.List;
import java.util.UUID;

@Entity
public class Department {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private UUID id;

    private String code;

    private String name;

    private String description;

    @OneToOne(mappedBy = "department",  cascade = CascadeType.ALL)
    private List<Faculty> faculties;

    @OneToMany(mappedBy = "department", cascade = CascadeType.ALL)
    private List<Student> students;

    @OneToMany(mappedBy = "", cascade = CascadeType.ALL)
    private List<Course> courses;
}
