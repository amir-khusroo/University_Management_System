package com.UniversityManagementSystem.entity;

import com.UniversityManagementSystem.enums.AttendenceStatus;
import jakarta.persistence.*;

import java.util.Date;
import java.util.UUID;

@Entity
public class Attendence {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;

    @ManyToOne
    private Student student;

    @ManyToOne
    private CourseSection courseSection;

    private Date date;

    @Enumerated(EnumType.STRING)
    private AttendenceStatus attendenceStatus;
}
