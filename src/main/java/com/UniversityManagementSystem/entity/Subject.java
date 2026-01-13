package com.UniversityManagementSystem.entity;

import jakarta.persistence.*;
import lombok.Data;

import java.util.List;
import java.util.UUID;

@Entity
@Data
public class Subject {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;

    private String code;

    private String name;

    private int credit;

    private int maxMarks;

    private int passingMarks;

    @ManyToOne
    private Semester semester;


}
