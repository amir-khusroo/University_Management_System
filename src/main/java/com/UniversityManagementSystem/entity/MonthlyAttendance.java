package com.UniversityManagementSystem.entity;

import jakarta.persistence.*;
import lombok.Data;

@Entity
@Data
public class MonthlyAttendance {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;


    private int month;

    private int year;

    private int totalClasses;

    private int presentClasses;

    @ManyToOne
    private Student student;

    @ManyToOne
    private Subject subject;
}
