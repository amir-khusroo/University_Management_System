package com.UniversityManagementSystem.entity;

import jakarta.persistence.*;

import java.util.List;
import java.util.UUID;

@Entity
public class CourseSection {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;

    private Semester semester;

    @ManyToOne
    private Course course;

    @OneToMany(mappedBy = "courseSection", cascade = CascadeType.ALL)
    private List<Subject> subjectList;

}
