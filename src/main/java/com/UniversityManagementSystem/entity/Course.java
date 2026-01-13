package com.UniversityManagementSystem.entity;

import jakarta.persistence.*;

import java.util.List;
import java.util.UUID;

@Entity
public class Course {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;

    private String title;

    private String code;

    @ManyToOne
    private Department department;

    @OneToMany(mappedBy = "course", cascade = CascadeType.ALL)
    List<Semester> semesters;

}
