package com.UniversityManagementSystem.entity;

import jakarta.persistence.*;
import lombok.Data;

import java.time.LocalDate;
import java.util.List;

@Entity
@Data
public class Semester {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;

    private String title;

    private int semesterNo;

    @ManyToOne
    private Course course;

    @OneToMany(mappedBy = "semester", cascade = CascadeType.ALL)
    private List<Subject> subjects;

    @ManyToMany(mappedBy = "semesters")
    private List<Student> students;

    private LocalDate startDate;
    private LocalDate endDate;
}
