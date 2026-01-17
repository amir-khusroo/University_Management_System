package com.UniversityManagementSystem.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;


@RestController
public class UserController {

    @GetMapping("/admin/info")
    public String checkAdmin(){
        return "i am admin";
    }

    @GetMapping("/student/info")
    public String checkStudent(){
        return "i am a student";
    }

    @GetMapping("/faculty/info")
    public String checkFaculty(){
        return "i am a faculty";
    }
}
