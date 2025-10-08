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

    @ManyToOne
    private CourseSection courseSection;

    @ManyToMany
    @JoinTable(
            name = "subject_enrollments", // join table
            joinColumns = @JoinColumn(name = "student_id"),
            inverseJoinColumns = @JoinColumn(name = "subject_id")
    )
    private List<Subject> subjects;

    @OneToMany(mappedBy = "student", cascade = CascadeType.ALL)
    private List<Attendence> attendenceList;


}
